package org.codehaus.mojo.cucumber;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.maven.doxia.module.markdown.MarkdownToDoxiaHtmlSerializer;
import org.apache.maven.doxia.parser.ParseException;
import org.apache.maven.doxia.parser.Parser;
import org.apache.maven.doxia.sink.Sink;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.util.IOUtil;
import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;
import org.pegdown.ast.RootNode;

@Component(role = Parser.class, hint = "markdown")
public class MarkdownParser extends org.apache.maven.doxia.module.markdown.MarkdownParser {

    /**
     * The role hint for the {@link MarkdownParser} Plexus component.
     */
    public static final String ROLE_HINT = "markdown";

    /**
     * The {@link PegDownProcessor} used to convert Pegdown documents to HTML.
     */
    protected final PegDownProcessor pegDownProcessor = new PegDownProcessor(Extensions.ALL
            & ~Extensions.HARDWRAPS);

    /**
     * {@inheritDoc}
     */
    @Override
    public void parse(Reader source, Sink sink) throws ParseException {
        try {
            String toParse = IOUtil.toString(source);
//            System.out.println("PegDown String to parse : "+ toParse);
            RootNode rootNode = pegDownProcessor.parseMarkdown(toParse.toCharArray());
            String markdownAsHtml = new MarkdownToDoxiaHtmlSerializer().toHtml(rootNode);
//            System.out.println("PegDown String to html : "+ markdownAsHtml);
            super.parse(new StringReader("<html><body>" + markdownAsHtml + "</body></html>"), sink);
        } catch (IOException e) {
            throw new ParseException("Failed reading Markdown source document", e);
        }
    }
}