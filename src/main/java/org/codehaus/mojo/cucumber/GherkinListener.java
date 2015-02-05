package org.codehaus.mojo.cucumber;

import gherkin.lexer.Listener;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.maven.doxia.sink.Sink;
import org.codehaus.mojo.cucumber.bean.FeatureSummary;

/**
 * @author Denis Cabasson
 * @modifiedBy Qiuliang Tang
 */

public class GherkinListener implements Listener {

    public static final String APT_LANGUAGE = "apt";

    public static final String MARKDOWN_LANGUAGE = "markdown";

    private final Sink sink;

    private int previousRowLine = -1;

    private final FeatureSummary featureSummary = new FeatureSummary();

    private final Map<String, String> personas;

    /**
     * The language used in the description. <br />
     * Can typically be apt or markdown.
     */
    private final String descriptionLanguage;

    public GherkinListener(final Sink sink, final Map<String, String> personas) {
        this(sink, personas, APT_LANGUAGE);
    }

    public GherkinListener(final Sink sink, final Map<String, String> personas, String descriptionLanguage) {
        this.sink = sink;
        this.personas = personas;
        this.descriptionLanguage = descriptionLanguage;
    }

    public void background(final String keyword, final String name, final String description, final int line) {
        final String confDescription = this.parseDescriptionForMarkup(description);
        final String localDescription = this.parseDescriptionForPersonas(confDescription);
        try {
            this.sink.lineBreak();
            this.sink.section2();
            this.sink.sectionTitle3();
            if (StringUtils.isNotBlank(name)) {
                this.sink.text(name);
            } else {
                this.sink.text("Background");
            }
            this.sink.sectionTitle3_();
            this.sink.section2_();
            this.sink.paragraph();
            this.sink.text(localDescription);
            this.sink.paragraph_();
        } catch (final Exception e) {
        }
    }

    public void comment(final String comment, final int arg1) {
        // TODO Auto-generated method stub

    }

    public void docString(final String contentType, final String content, final int line) {
        try {
            this.sink.paragraph();
            this.sink.text(contentType);
            this.sink.paragraph_();
            this.sink.paragraph();
            this.sink.text(content);
            this.sink.paragraph_();
        } catch (final Exception e) {
        }
    }

    public void eof() {
        // TODO Auto-generated method stub

    }

    public void examples(final String keyword, final String name, final String description, final int line) {
        final String confDescription = this.parseDescriptionForMarkup(description);
        final String localDescription = this.parseDescriptionForPersonas(confDescription);
        try {
            this.sink.section3();
            this.sink.italic();
            this.sink.text(keyword);
            this.sink.italic_();
            this.sink.text(" ");
            this.sink.text(name);
            this.sink.section3_();
            this.sink.paragraph();
            this.sink.text(localDescription);
            this.sink.paragraph_();
        } catch (final Exception e) {
        }
    }

    public void feature(final String keyword, final String name, final String description, final int line) {
//        System.out.println("Found feature : " + name + " with description : " + description);
        final String confDescription = this.parseDescriptionForMarkup(description);
//        System.out.println("Conf description : " + confDescription);
        final String localDescription = this.parseDescriptionForPersonas(confDescription);
        // capture the title of the feature at that point.
        this.featureSummary.setFeatureTitle(name);
        this.featureSummary.setFeatureDescription(localDescription);
        try {
            this.sink.lineBreak();
            this.sink.lineBreak();
            this.sink.section1();
            this.sink.anchor(name);
            this.sink.section1_();
            this.sink.paragraph();
            this.sink.text(localDescription);
            this.sink.paragraph_();
        } catch (final Exception e) {
        }
    }

    public void row(final List<String> cells, final int line) {
        try {
            boolean headerLine = false;
            if (this.previousRowLine == -1 || this.previousRowLine != line - 1) {
                // Start of the table
                this.sink.table();
                headerLine = true;
            }
            this.sink.tableRow();
            this.previousRowLine = line;
            for (final String cell : cells) {
                if (headerLine) {
                    this.sink.tableHeaderCell();
                } else {
                    this.sink.tableCell();
                }

                this.sink.text(cell.length() == 0 ? " " : cell);

                if (headerLine) {
                    this.sink.tableHeaderCell_();
                } else {
                    this.sink.tableCell_();
                }

            }
            this.sink.tableRow_();

        } catch (final Exception e) {
        }

    }

    public void scenario(final String keyword, final String name, final String description, final int line) {
        final String confDescription = this.parseDescriptionForMarkup(description);
        final String localDescription = this.parseDescriptionForPersonas(confDescription);
        try {
            this.sink.lineBreak();
            this.sink.section2();
            this.sink.sectionTitle3();
            // this.sink.text(keyword);
            // this.sink.text(" ");
            this.sink.text(name);
            this.sink.sectionTitle3_();
            this.sink.section2_();
            this.sink.paragraph();
            this.sink.text(localDescription);
            this.sink.paragraph_();
        } catch (final Exception e) {
        }

    }

    public void scenarioOutline(final String keyword, final String name, final String description, final int line) {
        this.scenario(keyword, name, description, line);
    }

    public void step(final String keyword, final String name, final int line) {
        final String localDescription = this.parseDescriptionForPersonas(name);
        try {
            final String strippedKeyword = StringUtils.strip(keyword);
            this.sink.paragraph();
            if ("and".equalsIgnoreCase(strippedKeyword)) {
                this.sink.text("  ");
            }
            this.sink.bold();
            this.sink.text(strippedKeyword);
            this.sink.bold_();
            this.sink.text(" ");
            this.sink.text(localDescription);
            this.sink.paragraph_();
        } catch (final Exception e) {
        }
    }

    public void tag(final String arg0, final int arg1) {
        // TODO Auto-generated method stub
    }

    public FeatureSummary getFeatureSummary() {
        return this.featureSummary;
    }

    /**
     * Parses the description for a markup language. <br>
     * Which language to use is driven by {@link #descriptionLanguage}.
     * 
     * @param description the description in a markup format
     * @return the description in the Confluence format
     */
    private String parseDescriptionForMarkup(final String description) {
        if (MARKDOWN_LANGUAGE.equals(this.descriptionLanguage)) {
            return FeaturesReport.parseDescriptionForMd(description);
        } else {
            return FeaturesReport.parseDescriptionForApt(description);
        }
    }

    private String parseDescriptionForPersonas(final String description) {
        String localDescription = description;
        for (final String persona : this.personas.keySet()) {
            localDescription = localDescription.replaceAll(persona, "[$0|" + this.personas.get(persona) + "]");
        }
        return localDescription;
    }

}
