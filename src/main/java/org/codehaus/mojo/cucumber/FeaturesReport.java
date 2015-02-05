package org.codehaus.mojo.cucumber;

import gherkin.lexer.I18nLexer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.doxia.module.apt.AptParser;
import org.apache.maven.doxia.module.confluence.ConfluenceSinkFactory;
import org.apache.maven.doxia.parser.Parser;
import org.apache.maven.doxia.sink.AbstractSink;
import org.apache.maven.doxia.sink.Sink;
import org.apache.maven.doxia.sink.SinkEventAttributes;
import org.apache.maven.doxia.sink.SinkFactory;
import org.apache.maven.doxia.siterenderer.Renderer;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.reporting.AbstractMavenReport;
import org.apache.maven.reporting.MavenReportException;
import org.apache.maven.scm.ChangeSet;
import org.apache.maven.scm.ScmException;
import org.apache.maven.scm.ScmFileSet;
import org.apache.maven.scm.ScmRevision;
import org.apache.maven.scm.ScmVersion;
import org.apache.maven.scm.command.changelog.ChangeLogScmResult;
import org.apache.maven.scm.manager.ScmManager;
import org.apache.maven.scm.provider.ScmProviderRepository;
import org.apache.maven.scm.repository.ScmRepository;
import org.codehaus.mojo.cucumber.bean.FeatureSummary;
import org.codehaus.plexus.util.DirectoryWalkListener;
import org.codehaus.plexus.util.DirectoryWalker;
import org.codehaus.plexus.util.FileUtils;
import org.codehaus.plexus.util.IOUtil;

import confluence.rpc.soap_axis.confluenceservice.ConfluenceServiceProxy;

/**
 * @author Denis Cabasson
 * @modifiedBy Qiuliang Tang
 * @goal features
 */

public class FeaturesReport extends AbstractMavenReport {

    /**
     * The version of the confluence service to contact
     * 
     * @parameter default-value=2
     * @required
     */
    private Integer confluenceWsdlVersion = 2;

    /**
     * the output directory is not used
     * 
     * @parameter default-value="${project.reporting.outputDirectory}"
     * @required
     */
    private File outputDirectory;

    /**
     * the parent page for creating feature pages
     * 
     * @parameter default-value="ICOS"
     * @required
     */
    private String confluenceSpaceKey = "ICOS";

    /**
     * the parent page for creating feature pages
     * 
     * @parameter default-value="ICOS Capabilities"
     * @required
     */
    private String confluenceParentPage = "ICOS Capabilities";

    /**
     * the location of the confluence server
     * 
     * @parameter default-value="http://confluence"
     * @required
     */
    private String confluenceUrl = "http://confluence";

    /**
     * the username for publishing to the confluence server, if different from the scm username
     * 
     * @parameter default-value="http://confluence"
     * @required
     */
    private String confluenceUsername = null;

    /**
     * the password for publishing to the confluence server, if different from the scm password
     * 
     * @parameter
     */
    private String confluencePassword = null;

    /**
     * @parameter expression="${project.scm.developerConnection}"
     * @readonly
     */
    private String urlScm;

    /**
     * @component
     */
    private ScmManager scmManager;

    /**
     * The username that is used when connecting to the SCM system.
     * 
     * @parameter expression="${scm.username}"
     */
    private String username;

    /**
     * The password that is used when connecting to the SCM system.
     * 
     * @parameter expression="${scm.password}"
     */
    private String password;

    /**
     * The upper limit for the SVN revision to be used by this plugin
     * 
     * @parameter
     */
    private Integer topSvnRevision;

    static class CapabilityDirectory {
        public String name;

        public SortedMap<String, UseCaseDirectory> useCases = new TreeMap<String, UseCaseDirectory>();

        CapabilityDirectory(final String name) {
            this.name = name;
        }
    }

    class FeatureDirectoryWalker implements DirectoryWalkListener {

        /** List of the capabilites, indexed by their names. */
        private final SortedMap<String, CapabilityDirectory> capabilities = new TreeMap<String, CapabilityDirectory>();

        private File baseDir;

        public void debug(final String message) {
            FeaturesReport.this.getLog().debug("Feature Scanner: " + message);
        }

        public void directoryWalkFinished() {
            for (final String aCapability : this.capabilities.keySet()) {
                final CapabilityDirectory capability = this.capabilities.get(aCapability);
                FeaturesReport.this.confluenceClient.generateConfluenceCapabilityPage(confluenceParentPage,
                        capability.name);

                for (final String aUseCase : capability.useCases.keySet()) {
                    final UseCaseDirectory useCase = capability.useCases.get(aUseCase);
                    String epicName = useCase.name;
                    String wikiContent = "";
                    String textComments = "";
                    if (useCase.packageFile != null) {
                        try {
                            // Get confluence sink
                            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            final InputStreamReader reader = new InputStreamReader(new FileInputStream(
                                    useCase.packageFile), "UTF8");
                            final ConfluenceSinkFactory factory = new ConfluenceSinkFactory();
                            final Sink confluenceSink = factory.createSink(bos, "UTF-8");
                            final TitleSinkWrapper sink = new TitleSinkWrapper(confluenceSink);
                            final Parser parser;
                            if (isEpicMarkdown(useCase)) {
                                parser = new MarkdownParser();
                            } else {
                                parser = new AptParser();
                            }
                            parser.parse(reader, sink);
                            IOUtil.close(reader);
                            sink.flush();
                            sink.close();
                            final String title = StringUtils.defaultString(sink.getTitle()).trim();
                            if (!title.isEmpty()) {
                                epicName = title;
                            }

                            wikiContent = FeaturesReport.getWikiContent(bos);

                            // get revision information
                            final StringBuilder builder = new StringBuilder();
                            try {
                                final ChangeLogScmResult clScmResult = FeaturesReport.this.log(useCase.packageFile,
                                        null, toVersion);
                                for (final ChangeSet aChangeSet : clScmResult.getChangeLog().getChangeSets()) {
                                    builder.append("\n");
                                    builder.append("Updated from revision ");
                                    builder.append(aChangeSet.getRevision());
                                    builder.append(" by ");
                                    builder.append(aChangeSet.getAuthor());
                                    builder.append(" : ");
                                    builder.append(aChangeSet.getComment().replaceAll("\\s+", " "));
                                }
                            } catch (final MojoExecutionException e) {
                                FeaturesReport.this.getLog().error(e);
                            }
                            textComments = builder.toString();

                        } catch (final Exception e) {
                            FeaturesReport.this.getLog().warn("Unable to generate the epic package content correctly",
                                    e);
                        }
                    }
                    // generate the confluence epic page before the generation of feature
                    // pages
                    // in order to be able to generate the feature pages as children
                    Boolean epicFeatureSummariesChanged = false;
                    FeaturesReport.this.confluenceClient.generateConfluenceEpicPage(capability.name, epicName,
                            wikiContent, textComments, epicFeatureSummariesChanged, false);

                    // generate the confluence feature pages
                    final List<FeatureSummary> featureSummaries = new ArrayList<FeatureSummary>();
                    for (final File feature : useCase.features) {
                        Boolean featureChanged = false;
                        featureChanged = FeaturesReport.this.generateFeaturePage(epicName, feature, featureSummaries,
                                useCase);
                        if (featureChanged) {
                            epicFeatureSummariesChanged = true;
                        }
                    }

                    // generate the confluence epic page after the generation of feature
                    // pages
                    // in order to be able to add the feature summaries to the epic page
                    // content
                    if (!featureSummaries.isEmpty()) {
                        try {

                            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            final ConfluenceSinkFactory factory = new ConfluenceSinkFactory();
                            final Sink confluenceSink = factory.createSink(bos, "UTF-8");

                            confluenceSink.lineBreak();
                            confluenceSink.section1();
                            confluenceSink.sectionTitle1();
                            confluenceSink.text("Feature Summaries");
                            confluenceSink.sectionTitle1_();

                            for (final FeatureSummary featureSummary : featureSummaries) {
                                confluenceSink.section2();

                                confluenceSink.sectionTitle4();
                                confluenceSink.link(featureSummary.getFeatureTitle());
                                confluenceSink.text(featureSummary.getFeatureTitle());
                                confluenceSink.link_();
                                confluenceSink.sectionTitle4_();

                                confluenceSink.paragraph();
                                confluenceSink.text(featureSummary.getFeatureDescription());
                                confluenceSink.paragraph_();

                                confluenceSink.section2_();

                            }
                            confluenceSink.section1_();

                            confluenceSink.flush();
                            confluenceSink.close();
                            final String wikiFeatureSummariesContent = FeaturesReport.getWikiContent(bos);
                            wikiContent = wikiContent + wikiFeatureSummariesContent;

                        } catch (final Exception e) {
                            FeaturesReport.this.getLog().warn(
                                    "Unable to generate the epic feature summary content correctly", e);
                        }
                    }
                    FeaturesReport.this.confluenceClient.generateConfluenceEpicPage(capability.name, epicName,
                            wikiContent, textComments, epicFeatureSummariesChanged, true);
                }

            }
        }

        public void directoryWalkStarting(final File directory) {
            this.baseDir = directory;
            FeaturesReport.this.getLog().debug(
                    "Feature Scanner: Starting the directory walker in " + this.baseDir.getAbsolutePath());
        }

        public void directoryWalkStep(final int percentage, final File aFile) {
            FeaturesReport.this.getLog().info("Visting file : " + aFile.getAbsolutePath());
            final String fullFileDirPath = aFile.getParent();
            final String[] directories = fullFileDirPath.split("\\\\");
            final String capabilityName = directories[directories.length - 2];
            final String useCaseName = directories[directories.length - 1];
            if (!this.capabilities.containsKey(capabilityName)) {
                this.capabilities.put(capabilityName, new CapabilityDirectory(capabilityName));
            }
            final CapabilityDirectory capability = this.capabilities.get(capabilityName);
            if (!capability.useCases.containsKey(useCaseName)) {
                capability.useCases.put(useCaseName, new UseCaseDirectory(useCaseName, new File(fullFileDirPath)));
            }
            final UseCaseDirectory useCase = capability.useCases.get(useCaseName);
            final String fileName = FilenameUtils.getBaseName(aFile.getName());
            final String fileExtension = FileUtils.getExtension(aFile.getAbsolutePath());
            if ("apt".equals(fileExtension) || "md".equals(fileExtension)) {
                if ("signoff".equals(fileName)) {
                    useCase.signoffFile = aFile;
                } else if ("package".equals(fileName)) {
                    useCase.packageFile = aFile;
                } else {
                    FeaturesReport.this.getLog().warn("Unrecognized documentation file : " + aFile.getAbsolutePath());
                }
            } else if ("feature".equals(fileExtension)) {
                useCase.features.add(aFile);
            } else if ("txt".equals(fileExtension) && "personas".equals(fileName)) {
                this.loadPersonas(aFile);
                this.capabilities.remove(capabilityName);
            }
        }

        /**
         * Loads the personas from a given text file.
         * 
         * @param personasFile the file containing the personas to use
         */
        private void loadPersonas(final File personasFile) {
            try {
                final LineNumberReader lReader = new LineNumberReader(new FileReader(personasFile));
                String aLine;
                while ((aLine = lReader.readLine()) != null) {
                    final String tokens[] = aLine.split(",");
                    FeaturesReport.this.personas.put(tokens[0], tokens[1]);
                }
                lReader.close();
            } catch (final IOException e) {
                FeaturesReport.this.getLog().warn("Error while reading the personas file", e);
            }

        }
    }

    static class UseCaseDirectory {
        public String name;

        public File parentFolder;

        public File packageFile;

        public File signoffFile;

        public List<File> features = new ArrayList<File>();

        UseCaseDirectory(final String name, final File parentFolder) {
            this.name = name;
            this.parentFolder = parentFolder;
        }
    }

    static class TitleSinkWrapper extends AbstractSink {

        private String title;

        private Boolean inTitle = false;

        private final Sink wrappedSink;

        public TitleSinkWrapper(final Sink sink) {
            this.wrappedSink = sink;
        }

        public void title() {
            this.inTitle = true;
            this.wrappedSink.title();
        }

        public void text(final String text) {
            if (this.inTitle) {
                this.title = text;
            }
            this.wrappedSink.text(text);
        }

        public void title_() {
            this.inTitle = false;
            this.wrappedSink.title_();
        }

        public String getTitle() {
            return this.title;
        }

        public void anchor(final String arg0) {
            this.wrappedSink.anchor(arg0);
        }

        public void anchor(final String arg0, final SinkEventAttributes arg1) {
            this.wrappedSink.anchor(arg0, arg1);

        }

        public void anchor_() {
            this.wrappedSink.anchor_();

        }

        public void author() {
            this.wrappedSink.author();

        }

        public void author(final SinkEventAttributes arg0) {
            this.wrappedSink.author(arg0);

        }

        public void author_() {
            this.wrappedSink.author_();

        }

        public void body() {
            this.wrappedSink.body();

        }

        public void body(final SinkEventAttributes arg0) {
            this.wrappedSink.body(arg0);

        }

        public void body_() {
            this.wrappedSink.body_();

        }

        public void bold() {
            this.wrappedSink.bold();

        }

        public void bold_() {
            this.wrappedSink.bold_();

        }

        public void close() {
            this.wrappedSink.close();

        }

        public void comment(final String arg0) {
            this.wrappedSink.comment(arg0);

        }

        public void date() {
            this.wrappedSink.date();

        }

        public void date(final SinkEventAttributes arg0) {
            this.wrappedSink.date(arg0);

        }

        public void date_() {
            this.wrappedSink.date_();

        }

        public void definedTerm() {
            this.wrappedSink.definedTerm();

        }

        public void definedTerm(final SinkEventAttributes arg0) {
            this.wrappedSink.definedTerm(arg0);

        }

        public void definedTerm_() {
            this.wrappedSink.definedTerm_();

        }

        public void definition() {
            this.wrappedSink.definition();

        }

        public void definition(final SinkEventAttributes arg0) {
            this.wrappedSink.definition(arg0);

        }

        public void definitionList() {
            this.wrappedSink.definitionList();

        }

        public void definitionList(final SinkEventAttributes arg0) {
            this.wrappedSink.definitionList(arg0);

        }

        public void definitionListItem() {
            this.wrappedSink.definitionListItem();

        }

        public void definitionListItem(final SinkEventAttributes arg0) {
            this.wrappedSink.definitionListItem(arg0);

        }

        public void definitionListItem_() {
            this.wrappedSink.definitionListItem_();

        }

        public void definitionList_() {
            this.wrappedSink.definitionList_();

        }

        public void definition_() {
            this.wrappedSink.definition_();

        }

        public void figure() {
            this.wrappedSink.figure();

        }

        public void figure(final SinkEventAttributes arg0) {
            this.wrappedSink.figure(arg0);

        }

        public void figureCaption() {
            this.wrappedSink.figureCaption();

        }

        public void figureCaption(final SinkEventAttributes arg0) {
            this.wrappedSink.figureCaption(arg0);

        }

        public void figureCaption_() {
            this.wrappedSink.figureCaption_();

        }

        public void figureGraphics(final String arg0) {
            this.wrappedSink.figureGraphics(arg0);

        }

        public void figureGraphics(final String arg0, final SinkEventAttributes arg1) {
            this.wrappedSink.figureGraphics(arg0, arg1);

        }

        public void figure_() {
            this.wrappedSink.figure_();

        }

        public void flush() {
            this.wrappedSink.flush();

        }

        public void head() {
            this.wrappedSink.head();

        }

        public void head(final SinkEventAttributes arg0) {
            this.wrappedSink.head(arg0);

        }

        public void head_() {
            this.wrappedSink.head_();

        }

        public void horizontalRule() {
            this.wrappedSink.horizontalRule();

        }

        public void horizontalRule(final SinkEventAttributes arg0) {
            this.wrappedSink.horizontalRule(arg0);

        }

        public void italic() {
            this.wrappedSink.italic();

        }

        public void italic_() {
            this.wrappedSink.italic_();

        }

        public void lineBreak() {
            this.wrappedSink.lineBreak();

        }

        public void lineBreak(final SinkEventAttributes arg0) {
            this.wrappedSink.lineBreak(arg0);

        }

        public void link(final String arg0) {
            this.wrappedSink.link(arg0);

        }

        public void link(final String arg0, final SinkEventAttributes arg1) {
            this.wrappedSink.link(arg0, arg1);

        }

        public void link_() {
            this.wrappedSink.link_();

        }

        public void list() {
            this.wrappedSink.list();

        }

        public void list(final SinkEventAttributes arg0) {
            this.wrappedSink.list(arg0);

        }

        public void listItem() {
            this.wrappedSink.listItem();

        }

        public void listItem(final SinkEventAttributes arg0) {
            this.wrappedSink.listItem(arg0);

        }

        public void listItem_() {
            this.wrappedSink.listItem_();

        }

        public void list_() {
            this.wrappedSink.list_();

        }

        public void monospaced() {
            this.wrappedSink.monospaced();

        }

        public void monospaced_() {
            this.wrappedSink.monospaced_();

        }

        public void nonBreakingSpace() {
            this.wrappedSink.nonBreakingSpace();

        }

        public void numberedList(final int arg0) {
            this.wrappedSink.numberedList(arg0);

        }

        public void numberedList(final int arg0, final SinkEventAttributes arg1) {
            this.wrappedSink.numberedList(arg0, arg1);

        }

        public void numberedListItem() {
            this.wrappedSink.numberedListItem();

        }

        public void numberedListItem(final SinkEventAttributes arg0) {
            this.wrappedSink.numberedListItem(arg0);

        }

        public void numberedListItem_() {
            this.wrappedSink.numberedListItem_();

        }

        public void numberedList_() {
            this.wrappedSink.numberedList_();

        }

        public void pageBreak() {
            this.wrappedSink.pageBreak();

        }

        public void paragraph() {
            this.wrappedSink.paragraph();

        }

        public void paragraph(final SinkEventAttributes arg0) {
            this.wrappedSink.paragraph(arg0);

        }

        public void paragraph_() {
            this.wrappedSink.paragraph_();

        }

        public void rawText(final String arg0) {
            this.wrappedSink.rawText(arg0);

        }

        public void section(final int arg0, final SinkEventAttributes arg1) {
            this.wrappedSink.section(arg0, arg1);

        }

        public void section1() {
            this.wrappedSink.section1();

        }

        public void section1_() {
            this.wrappedSink.section1_();

        }

        public void section2() {
            this.wrappedSink.section2();

        }

        public void section2_() {
            this.wrappedSink.section2_();

        }

        public void section3() {
            this.wrappedSink.section3();

        }

        public void section3_() {
            this.wrappedSink.section3_();

        }

        public void section4() {
            this.wrappedSink.section4();

        }

        public void section4_() {
            this.wrappedSink.section4_();

        }

        public void section5() {
            this.wrappedSink.section5();

        }

        public void section5_() {
            this.wrappedSink.section5_();

        }

        public void sectionTitle() {
            this.wrappedSink.sectionTitle();

        }

        public void sectionTitle(final int arg0, final SinkEventAttributes arg1) {
            this.wrappedSink.sectionTitle(arg0, arg1);

        }

        public void sectionTitle1() {
            this.wrappedSink.sectionTitle1();

        }

        public void sectionTitle1_() {
            this.wrappedSink.sectionTitle1_();

        }

        public void sectionTitle2() {
            this.wrappedSink.sectionTitle2();

        }

        public void sectionTitle2_() {
            this.wrappedSink.sectionTitle2_();

        }

        public void sectionTitle3() {
            this.wrappedSink.sectionTitle3();

        }

        public void sectionTitle3_() {
            this.wrappedSink.section3_();

        }

        public void sectionTitle4() {
            this.wrappedSink.sectionTitle4();

        }

        public void sectionTitle4_() {
            this.wrappedSink.sectionTitle4_();

        }

        public void sectionTitle5() {
            this.wrappedSink.sectionTitle5();

        }

        public void sectionTitle5_() {
            this.wrappedSink.sectionTitle5_();

        }

        public void sectionTitle_() {
            this.wrappedSink.sectionTitle_();

        }

        public void sectionTitle_(final int arg0) {
            this.wrappedSink.sectionTitle_(arg0);

        }

        public void section_(final int arg0) {
            this.wrappedSink.section_(arg0);

        }

        public void table() {
            this.wrappedSink.table();

        }

        public void table(final SinkEventAttributes arg0) {
            this.wrappedSink.table(arg0);

        }

        public void tableCaption() {
            this.wrappedSink.tableCaption();

        }

        public void tableCaption(final SinkEventAttributes arg0) {
            this.wrappedSink.tableCaption(arg0);

        }

        public void tableCaption_() {
            this.wrappedSink.tableCaption_();

        }

        public void tableCell() {
            this.wrappedSink.tableCell();

        }

        public void tableCell(final String arg0) {
            this.wrappedSink.tableCell(arg0);

        }

        public void tableCell(final SinkEventAttributes arg0) {
            this.wrappedSink.tableCell(arg0);

        }

        public void tableCell_() {
            this.wrappedSink.tableCell_();

        }

        public void tableHeaderCell() {
            this.wrappedSink.tableHeaderCell();

        }

        public void tableHeaderCell(final String arg0) {
            this.wrappedSink.tableHeaderCell(arg0);

        }

        public void tableHeaderCell(final SinkEventAttributes arg0) {
            this.wrappedSink.tableHeaderCell(arg0);

        }

        public void tableHeaderCell_() {
            this.wrappedSink.tableHeaderCell_();

        }

        public void tableRow() {
            this.wrappedSink.tableRow();

        }

        public void tableRow(final SinkEventAttributes arg0) {
            this.wrappedSink.tableRow(arg0);

        }

        public void tableRow_() {
            this.wrappedSink.tableRows_();

        }

        public void tableRows(final int[] arg0, final boolean arg1) {
            this.wrappedSink.tableRows(arg0, arg1);

        }

        public void tableRows_() {
            this.wrappedSink.tableRows_();

        }

        public void table_() {
            this.wrappedSink.table_();

        }

        public void text(final String arg0, final SinkEventAttributes arg1) {
            this.wrappedSink.text(arg0, arg1);

        }

        public void title(final SinkEventAttributes arg0) {
            this.wrappedSink.title(arg0);

        }

        public void unknown(final String arg0, final Object[] arg1, final SinkEventAttributes arg2) {
            this.wrappedSink.unknown(arg0, arg1, arg2);

        }

        public void verbatim(final boolean arg0) {
            this.wrappedSink.verbatim(arg0);

        }

        public void verbatim(final SinkEventAttributes arg0) {
            this.wrappedSink.verbatim(arg0);

        }

        public void verbatim_() {
            this.wrappedSink.verbatim_();

        }

    }

    /**
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;

    /**
     * @component
     */
    private Renderer siteRenderer;

    /**
     * @parameter default-value="${basedir}/src/main/features"
     * @required
     */
    private File featuresDirectory;

    /**
     * @parameter expression="${basedir}"
     * @required
     * @readonly
     */
    private File baseDir;

    private final Map<String, String> personas = new HashMap<String, String>();

    private ConfluenceSoapClient<? extends ConfluenceServiceProxy> confluenceClient;

    /**
     * The upper limit of the SVN revision to consider. This is intended to prevent race conditions
     * where a newer version might be available at svn log time as opposed to the initial checkout
     * of the code.
     */
    private ScmVersion toVersion;

    public static String getWikiContent(final ByteArrayOutputStream bos) throws UnsupportedEncodingException {
        String wikiContent = bos.toString("UTF-8");
        wikiContent = wikiContent.replaceAll("&amp;", "&");
        wikiContent = wikiContent.replaceAll("code\\|borderStyle=solid", "code");

        return wikiContent;
    }

    @Override
    protected void executeReport(final Locale locale) throws MavenReportException {

        if (confluenceWsdlVersion == 1) {
            this.confluenceClient = new ConfluenceV1SoapClient(getConfluenceUsername(), getConfluencePassword(),
                    confluenceSpaceKey, confluenceUrl);
        } else {
            this.confluenceClient = new ConfluenceV2SoapClient(getConfluenceUsername(), getConfluencePassword(),
                    confluenceSpaceKey, confluenceUrl);
        }

        if (topSvnRevision != null) { // there is an upper bound to what we are supposed to log
            this.toVersion = new ScmRevision(topSvnRevision.toString());
            this.getLog().info("The top revision has been set to " + topSvnRevision.toString());
        } else {
            this.toVersion = null;
            this.getLog().info("No top revision available, will use HEAD");
        }

        if (this.featuresDirectory.exists() && this.featuresDirectory.isDirectory()) {
            final List<String> allIncludes = new ArrayList<String>();
            allIncludes.add("**/package.apt");
            allIncludes.add("**/package.md");
            allIncludes.add("**/signoff.apt");
            allIncludes.add("**/*.feature");
            allIncludes.add("**/personas.txt");

            final DirectoryWalker dw = new DirectoryWalker();
            dw.setBaseDir(this.featuresDirectory);
            dw.setIncludes(allIncludes);
            dw.setExcludes(new ArrayList<String>());

            dw.addDirectoryWalkListener(new FeatureDirectoryWalker());
            dw.scan();
        } else {
            this.getLog().debug("No features in that project");
        }
    }

    /**
     * Handling the feature file to generate a confluence page.
     * 
     */
    protected Boolean generateFeaturePage(final String parentPageTitle, final File featureFile,
            final List<FeatureSummary> featureSummaries, final UseCaseDirectory epicInformation) {
        Boolean featureChanged = false;
        try {
            this.getLog().debug("Generating feature file : " + featureFile.getAbsolutePath());
            final ConfluenceSinkFactory factory = new ConfluenceSinkFactory();
            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
            final Sink sink = factory.createSink(bos, "UTF-8");

            final GherkinListener listener = new GherkinListener(sink, this.personas,
                    isEpicMarkdown(epicInformation) ? GherkinListener.MARKDOWN_LANGUAGE : GherkinListener.APT_LANGUAGE);
            final I18nLexer gherkinLexer = new I18nLexer(listener);
            gherkinLexer.scan(FileUtils.fileRead(featureFile, "UTF-8"));
            final FeatureSummary featureSummary = listener.getFeatureSummary();
		this.getLog().debug("Extracted summary : " + featureSummary.getFeatureDescription());
            featureSummaries.add(listener.getFeatureSummary());
            sink.flush();
            sink.close();

            String wikiContent = FeaturesReport.getWikiContent(bos);
		
		this.getLog().debug("Full Wiki Content : " + wikiContent);

            final String revisionInConfluence = this.confluenceClient.getCurrentPageVersion(featureSummary
                    .getFeatureTitle());
            if (revisionInConfluence == null) {
                this.getLog().debug("This page currently does not exist in Confluence");
            } else {
                this.getLog().debug(
                        "A version of the page ("+featureSummary.getFeatureTitle()+") already exists in Confluence, generated from revision : "
                                + revisionInConfluence);
            }

            final ScmVersion fromVersion;
            if (revisionInConfluence != null) { // there is already something in Confluence
                fromVersion = new ScmRevision(revisionInConfluence);
            } else {
                fromVersion = null;
            }

            // Add revision information
            final ChangeLogScmResult clScmResult = this.log(featureFile, fromVersion, toVersion);
            if (!clScmResult.getChangeLog().getChangeSets().isEmpty()) { // we have changes
                                                                         // since last version!
                this.getLog().debug("Changes have occured since last Scm Revision");
                final StringBuilder historyBuilder = new StringBuilder();
                final List<ChangeSet> changes = clScmResult.getChangeLog().getChangeSets();
                for (int i=changes.size()-1;i>=0;i--) {
                	final ChangeSet aChangeSet = changes.get(i);
                	historyBuilder.append("\n");
                    historyBuilder.append("Updated from revision ");
                    historyBuilder.append(aChangeSet.getRevision());
                    historyBuilder.append(" by ");
                    historyBuilder.append(aChangeSet.getAuthor());
                    historyBuilder.append(" : ");
                    historyBuilder.append(aChangeSet.getComment().replaceAll("\\s+", " "));
				}

                featureChanged = this.confluenceClient.generateConfluenceFeaturePage(parentPageTitle,
                        featureSummary.getFeatureTitle(), wikiContent, historyBuilder.toString());
            } else {
                this.getLog().debug("No changes to that page since last SCM revision");
            }

        } catch (final MojoExecutionException e) {
            this.getLog().warn("Unable to generate the feature page correctly", e);
        } catch (final IOException e) {
            this.getLog().warn("Unable to generate the feature page correctly", e);
        }
        return featureChanged;
    }

    /**
     * Returns the correct resource bundle according to the locale.
     * 
     * @param locale the locale of the user.
     * @return the bundle corresponding to the locale.
     */
    private ResourceBundle getBundle(final Locale locale) {
        return ResourceBundle.getBundle("cucumber-report", locale, this.getClass().getClassLoader());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.apache.maven.reporting.MavenReport#getDescription(java.util.Locale)
     */
    public String getDescription(final Locale locale) {
        return this.getBundle(locale).getString("report.cucumber.description");
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.apache.maven.reporting.MavenReport#getName(java.util.Locale)
     */
    public String getName(final Locale locale) {
        return this.getBundle(locale).getString("report.cucumber.name");
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.apache.maven.reporting.AbstractMavenReport#getOutputDirectory()
     */
    @Override
    protected String getOutputDirectory() {
        return this.outputDirectory.getAbsolutePath();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.apache.maven.reporting.MavenReport#getOutputName()
     */
    public String getOutputName() {
        return "cucumber";
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.apache.maven.reporting.AbstractMavenReport#getProject()
     */
    @Override
    protected MavenProject getProject() {
        return this.project;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.apache.maven.reporting.AbstractMavenReport#getSiteRenderer()
     */
    @Override
    protected Renderer getSiteRenderer() {
        return this.siteRenderer;
    }

    private ScmRepository getScmRepository(final File file) throws ScmException {
        final String actualScmUrl = this.urlScm + this.baseDir.toURI().relativize(file.toURI()).getPath();
        this.getLog().info("SCM url used to get the changes : " + actualScmUrl);

        final ScmRepository repository = this.scmManager.makeScmRepository(actualScmUrl);

        final ScmProviderRepository scmRepo = repository.getProviderRepository();
        if (StringUtils.isNotEmpty(this.username)) {
            this.getLog().debug("Setting username to : " + this.username);
            scmRepo.setUser(this.username);
        }
        if (StringUtils.isNotEmpty(this.password)) {
            this.getLog().debug("Setting password to : ******* ");
            scmRepo.setPassword(this.password);
        }

        return repository;
    }

    private ChangeLogScmResult log(final File file, final ScmVersion fromVersion, final ScmVersion toVersion)
            throws MojoExecutionException {
        final ChangeLogScmResult changeLog;
        try {
            this.getLog().debug("File to generate the changeset : " + file);
            this.getLog().debug("From version : " + fromVersion);
            final ScmRepository repository = this.getScmRepository(file);

            changeLog = this.scmManager.changeLog(repository,
                    new ScmFileSet(new File(file.getParent()), new File(file.getName())), fromVersion, toVersion);
        } catch (final Exception e) {
            throw new MojoExecutionException("Cannot get the branch information from the scm repository : \n"
                    + e.getLocalizedMessage(), e);
        }
        return changeLog;
    }

    public static String parseDescriptionForApt(final String description) {
        final Pattern startLinePattern = Pattern.compile("^(?!\\[)", Pattern.MULTILINE);
        final Matcher match = startLinePattern.matcher(description);
        final String descriptionWithSpaces = match.replaceAll("  ");
        String strConfluence = description;
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final StringReader reader = new StringReader(descriptionWithSpaces);
        final ConfluenceSinkFactory factory = new ConfluenceSinkFactory();
        try {
            final Sink sink = factory.createSink(bos, "UTF-8");
            final AptParser aptParser = new AptParser();
            aptParser.parse(reader, sink);
            sink.flush();
            sink.close();
            strConfluence = bos.toString("UTF-8");
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(reader);
        }
        return strConfluence;
    }

    public static String parseDescriptionForMd(final String description) {
//        System.out.println("Parsing for MD : " + description);
//        System.out.println("Parsing for MD length : " + description.length());
        String strConfluence = description;
//        System.out.println("Parsing for MD strConfluence length : " + strConfluence.length());
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final StringReader reader = new StringReader(description);
        final SinkFactory factory = new ConfluenceSinkFactory();
        try {
            final Sink sink = factory.createSink(bos, "UTF-8");
            final Parser parser = new MarkdownParser();
            parser.parse(reader, sink);
            sink.flush();
            sink.close();
//            System.out.println("Parsing for MD bos length : " + bos.size());
            strConfluence = bos.toString("UTF-8");
//            System.out.println("Parsing for MD strConfluence length after : " + strConfluence.length());
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(reader);
        }
//        System.out.println("Result length : " + strConfluence.length());
//        System.out.println("Result is : " + strConfluence);
        return strConfluence;
    }

    /**
     * Discovers whether this epic is using markdown rather than apt.
     * 
     * @param epicDirectory the information about this epic
     * @return <code>true</code> if the epic is using markdown, false otherwise
     */
    private static boolean isEpicMarkdown(final UseCaseDirectory epicDirectory) {
        
        return epicDirectory.packageFile!=null && ("md".equals(FileUtils.getExtension(epicDirectory.packageFile.getAbsolutePath())));

    }

    private String getConfluenceUsername() {
        return (this.confluenceUsername == null) ? this.username : this.confluenceUsername;
    }

    private String getConfluencePassword() {
        return (this.confluencePassword == null) ? this.password : this.confluencePassword;
    }
}
