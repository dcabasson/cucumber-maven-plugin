package org.codehaus.mojo.cucumber;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.atlassian.confluence.rpc.RemoteException;
import com.atlassian.confluence.rpc.soap.beans.RemotePage;
import com.atlassian.confluence.rpc.soap.beans.RemotePageUpdateOptions;

import confluence.rpc.soap_axis.confluenceservice_v2.ConfluenceSoapServiceProxy;

/**
 * @author Qiuliang Tang
 */

public class ConfluenceSoapClient {

    /**
     * @param args
     */
    private final String username;

    private final String password;

    private final String spaceKey;

    private final Map<String, String> attachmentsMap;

    public ConfluenceSoapClient(final String username, final String password) {
        this.username = username;
        this.password = password;
        this.spaceKey = "ICOS";
        this.attachmentsMap = new HashMap<String, String>();
    }

    public void generateConfluenceCapabilityPage(final String parentPageTitle, final String pageTitle) {
        // TODO Auto-generated method stub
        try {
            final ConfluenceSoapServiceProxy confluenceClient = new ConfluenceSoapServiceProxy();
            final String token = confluenceClient.login(this.username, this.password);

            RemotePage page;
            try {
                page = confluenceClient.getPage(token, this.spaceKey, pageTitle);
                // the page exists in confluence
            } catch (final RemoteException e) {
                // the page does not exist in confluence
                page = new RemotePage();

                page.setSpace(this.spaceKey);
                page.setTitle(pageTitle);
                final RemotePage parentPage = confluenceClient.getPage(token, this.spaceKey, parentPageTitle);
                page.setParentId(parentPage.getId());

                page = confluenceClient.storePage(token, page);
            }

        } catch (final Exception e) {
            e.printStackTrace();
        }

    }

    public void generateConfluenceEpicPage(final String parentPageTitle, final String pageTitle,
            final String wikiContent, final String textComments, final Boolean epicFeatureSummariesChanged,
            final Boolean isSecondTimeEnter) {
        try {
            final ConfluenceSoapServiceProxy confluenceClient = new ConfluenceSoapServiceProxy();
            final String token = confluenceClient.login(this.username, this.password);
            final String xhtmlContent = confluenceClient.convertWikiToStorageFormat(token, wikiContent);
            RemotePage page;
            try {
                page = confluenceClient.getPage(token, this.spaceKey, pageTitle);
                // the page exists in confluence

                if (isSecondTimeEnter) {
                    // move page to the new parent page if the parent page title changes
                    try {
                        final Long existingParentPageId = page.getParentId();
                        try {
                            final RemotePage existingParentPage = confluenceClient.getPage(token, existingParentPageId);
                            final String existingParentPageTitle = existingParentPage.getTitle();

                            if (!parentPageTitle.equals(existingParentPageTitle)) {
                                final RemotePage newParentPage = confluenceClient.getPage(token, this.spaceKey,
                                        parentPageTitle);
                                final Long newParentPageId = newParentPage.getId();
                                confluenceClient.movePage(token, page.getId(), newParentPageId, "append");
                            }
                        } catch (final Exception e) {
                            final RemotePage newParentPage = confluenceClient.getPage(token, this.spaceKey,
                                    parentPageTitle);
                            final Long newParentPageId = newParentPage.getId();
                            confluenceClient.movePage(token, page.getId(), newParentPageId, "append");
                        }
                    } catch (final Exception e) {
                        e.printStackTrace();
                    }

                    // update page based on the revisions of package.apt and the feature files
                    final String pageContent = page.getContent();
                    final Pattern pattern = Pattern.compile("Updated from revision (\\d+)");
                    final Matcher pageMatcher = pattern.matcher(pageContent);

                    if (pageMatcher.find()) {
                        // tipComment is contained in the pageContent
                        String tipComment = pageContent.substring(pageMatcher.start(), pageMatcher.end());
                        String verComments = "";
                        if (textComments.contains(tipComment)) {
                            verComments = textComments.substring(0, textComments.indexOf(tipComment)).trim();
                        } else {
                            verComments = textComments.trim();
                        }

                        if (!verComments.isEmpty() || epicFeatureSummariesChanged) {
                            final RemotePageUpdateOptions updateOptions = new RemotePageUpdateOptions();
                            if (!verComments.isEmpty()) {
                                final String topRevision = this.getTopRevision(textComments);
                                if (!topRevision.isEmpty()) {
                                    tipComment = "<p>&nbsp;</p><p>Updated from revision " + topRevision + "</p>";
                                    page.setContent(xhtmlContent + tipComment);
                                } else {
                                    // will not reach here since topRevision should not be empty
                                    page.setContent(xhtmlContent + tipComment);
                                }
                                updateOptions.setVersionComment("\n" + verComments);
                            } else {
                                page.setContent(xhtmlContent + tipComment);
                                updateOptions.setVersionComment("\nFeature summaries updated.");
                            }
                            confluenceClient.updatePage(token, page, updateOptions);
                        }
                    } else {
                        // tipComment is not contained in the pageContent
                        // meaning package.apt did not exist before
                        // the epic page content could be empty or contain only feature summaries
                        if (!textComments.isEmpty() || epicFeatureSummariesChanged) {
                            final RemotePageUpdateOptions updateOptions = new RemotePageUpdateOptions();
                            if (!textComments.isEmpty()) {
                                final String topRevision = this.getTopRevision(textComments);
                                if (!topRevision.isEmpty()) {
                                    final String tipComment = "<p>&nbsp;</p><p>Updated from revision " + topRevision
                                            + "</p>";
                                    page.setContent(xhtmlContent + tipComment);
                                } else {
                                    // will not reach here since topRevision should not be empty
                                    page.setContent(xhtmlContent);
                                }
                                updateOptions.setVersionComment(textComments);
                            } else {
                                page.setContent(xhtmlContent);
                                updateOptions.setVersionComment("\nFeature summaries updated.");
                            }
                            confluenceClient.updatePage(token, page, updateOptions);
                        }
                    }
                }

            } catch (final RemoteException e) {
                // the page does not exist in confluence
                if (!isSecondTimeEnter) {
                    // the very first time enter in the whole epic page history
                    page = new RemotePage();

                    page.setSpace(this.spaceKey);
                    page.setTitle(pageTitle);
                    final RemotePage parentPage = confluenceClient.getPage(token, this.spaceKey, parentPageTitle);
                    page.setParentId(parentPage.getId());
                    page = confluenceClient.storePage(token, page);
                }
            }

        } catch (final Exception e) {
            e.printStackTrace();
        }

    }

    public Boolean generateConfluenceFeaturePage(final String parentPageTitle, final String pageTitle,
            final String wikiContent, final String textComments) {
        Boolean featureChanged = false;
        try {
            final ConfluenceSoapServiceProxy confluenceClient = new ConfluenceSoapServiceProxy();
            final String token = confluenceClient.login(this.username, this.password);
            final String xhtmlContent = confluenceClient.convertWikiToStorageFormat(token, wikiContent);
            RemotePage page;
            try {
                page = confluenceClient.getPage(token, this.spaceKey, pageTitle);
                // the page exists in confluence

                // move page to the new parent page if the parent page title changes
                try {
                    final Long existingParentPageId = page.getParentId();
                    try {
                        final RemotePage existingParentPage = confluenceClient.getPage(token, existingParentPageId);
                        final String existingParentPageTitle = existingParentPage.getTitle();

                        if (!parentPageTitle.equals(existingParentPageTitle)) {
                            final RemotePage newParentPage = confluenceClient.getPage(token, this.spaceKey,
                                    parentPageTitle);
                            final Long newParentPageId = newParentPage.getId();
                            confluenceClient.movePage(token, page.getId(), newParentPageId, "append");
                        }
                    } catch (final Exception e) {
                        final RemotePage newParentPage = confluenceClient
                                .getPage(token, this.spaceKey, parentPageTitle);
                        final Long newParentPageId = newParentPage.getId();
                        confluenceClient.movePage(token, page.getId(), newParentPageId, "append");
                    }

                } catch (final Exception e) {
                    e.printStackTrace();
                }

                // update page based on revision
                final String pageContent = page.getContent();
                final Pattern pattern = Pattern.compile("Updated from revision (\\d+)");
                final Matcher pageMatcher = pattern.matcher(pageContent);

                if (pageMatcher.find()) {
                    String tipComment = pageContent.substring(pageMatcher.start(), pageMatcher.end());
                    String verComments = "";
                    if (textComments.contains(tipComment)) {
                        verComments = textComments.substring(0, textComments.indexOf(tipComment)).trim();
                    } else {
                        verComments = textComments.trim();
                    }

                    if (!verComments.isEmpty()) {
                        featureChanged = true;
                        final RemotePageUpdateOptions updateOptions = new RemotePageUpdateOptions();
                        final String topRevision = this.getTopRevision(textComments);
                        tipComment = "<p>&nbsp;</p><p>Updated from revision " + topRevision + "</p>";
                        page.setContent(xhtmlContent + tipComment);
                        updateOptions.setVersionComment("\n" + verComments);
                        confluenceClient.updatePage(token, page, updateOptions);
                    }
                } else {
                    // will not reach here since revision exists for each features
                    final RemotePageUpdateOptions updateOptions = new RemotePageUpdateOptions();
                    final String topRevision = this.getTopRevision(textComments);
                    final String tipComment = "<p>&nbsp;</p><p>Updated from revision " + topRevision + "</p>";
                    page.setContent(xhtmlContent + tipComment);
                    updateOptions.setVersionComment(textComments);
                    confluenceClient.updatePage(token, page, updateOptions);
                }

            } catch (final RemoteException e) {
                // the page does not exist in confluence
                featureChanged = true;
                page = new RemotePage();

                page.setSpace(this.spaceKey);
                page.setTitle(pageTitle);
                final RemotePage parentPage = confluenceClient.getPage(token, this.spaceKey, parentPageTitle);
                page.setParentId(parentPage.getId());
                page = confluenceClient.storePage(token, page);

                final RemotePageUpdateOptions updateOptions = new RemotePageUpdateOptions();
                final String topRevision = this.getTopRevision(textComments);
                final String tipComment = "<p>&nbsp;</p><p>Updated from revision " + topRevision + "</p>";
                page.setContent(xhtmlContent + tipComment);
                updateOptions.setVersionComment(textComments);
                confluenceClient.updatePage(token, page, updateOptions);
            }

        } catch (final Exception e) {
            e.printStackTrace();
        }

        return featureChanged;
    }

    public String getTopRevision(final String textComments) {
        final Pattern pattern = Pattern.compile("Updated from revision (\\d+)");
        final Matcher matcher = pattern.matcher(textComments);

        String topRevision = "";
        if (matcher.find()) {
            topRevision = matcher.group(1);
        }

        return topRevision;
    }

}
