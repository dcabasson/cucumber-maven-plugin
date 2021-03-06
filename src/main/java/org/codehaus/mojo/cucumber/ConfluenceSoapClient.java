package org.codehaus.mojo.cucumber;

import com.atlassian.confluence.rpc.RemoteException;
import com.atlassian.confluence.rpc.soap.beans.RemotePage;
import com.atlassian.confluence.rpc.soap.beans.RemotePageUpdateOptions;
import confluence.rpc.soap_axis.confluenceservice.ConfluenceServiceProxy;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Qiuliang Tang
 */

public abstract class ConfluenceSoapClient<P extends ConfluenceServiceProxy> {

	public static final String REVISION_REGEX = "Updated from revision (\\b[0-9a-f]{0,40}\\b)";

	private Log log;

	public void setLog(final Log log) {
		this.log = log;
	}

	public Log getLog() {
		if (this.log == null) {
			this.log = new SystemStreamLog();
		}

		return this.log;
	}

	private final String username;

	private final String password;

	private final String spaceKey;

	private final String confluenceServerRoot;

	public ConfluenceSoapClient(final String username, final String password) {
		this(username, password, "ICOS", "http://confluence");
	}

	public ConfluenceSoapClient(final String username, final String password,
			final String spaceKey, final String confluenceServerRoot) {
		this.username = username;
		this.password = password;
		this.spaceKey = spaceKey;
		this.confluenceServerRoot = confluenceServerRoot;
	}

	public void generateConfluenceCapabilityPage(final String parentPageTitle,
			final String pageTitle) {
		try {
			final ConfluenceServiceProxy confluenceClient = this.createClient();
			final String token = confluenceClient.login(this.username,
					this.password);
			RemotePage page;
			try {
				// the page exists in confluence
				page = confluenceClient.getPage(token, this.spaceKey, pageTitle);
			} catch (final RemoteException e) {
				// the page does not exist in confluence
				final RemotePage parentPage;
				parentPage = confluenceClient.getPage(token, this.spaceKey,
						parentPageTitle);

				page = new RemotePage();
				page.setSpace(this.spaceKey);
				page.setTitle(pageTitle);
				page.setParentId(parentPage.getId());
				page = confluenceClient.storePage(token, page);
			}

		} catch (final java.rmi.RemoteException e) {
			e.printStackTrace();
		}

	}

	public void generateConfluenceEpicPage(final String parentPageTitle,
			final String pageTitle, final String wikiContent,
			final String textComments,
			final Boolean epicFeatureSummariesChanged,
			final Boolean isSecondTimeEnter) {
		try {
			final P confluenceClient = this.createClient();
			final String token = confluenceClient.login(this.username, this.password);

			final String storableContent = this.createStorableContent(confluenceClient, token, wikiContent);
			RemotePage page;

			try {
				page = confluenceClient
						.getPage(token, this.spaceKey, pageTitle);
				// the page exists in confluence

				if (isSecondTimeEnter) {
					// move page to the new parent page if the parent page title
					// changes
					try {
						final Long existingParentPageId = page.getParentId();
						try {
							final RemotePage existingParentPage = confluenceClient
									.getPage(token, existingParentPageId);
							final String existingParentPageTitle = existingParentPage
									.getTitle();

							if (!parentPageTitle
									.equals(existingParentPageTitle)) {
								final RemotePage newParentPage = confluenceClient
										.getPage(token, this.spaceKey,
												parentPageTitle);
								final Long newParentPageId = newParentPage
										.getId();
								confluenceClient.movePage(token, page.getId(),
										newParentPageId, "append");
							}
						} catch (final Exception e) {
							final RemotePage newParentPage = confluenceClient
									.getPage(token, this.spaceKey,
											parentPageTitle);
							final Long newParentPageId = newParentPage.getId();
							confluenceClient.movePage(token, page.getId(),
									newParentPageId, "append");
						}
					} catch (final Exception e) {
						e.printStackTrace();
					}

					// update page based on the revisions of package.apt and the
					// feature
					// files
					final String pageContent = page.getContent();
					final Pattern pattern = Pattern
							.compile(REVISION_REGEX);
					final Matcher pageMatcher = pattern.matcher(pageContent);

					if (pageMatcher.find()) {
						// tipComment is contained in the pageContent
						String tipComment = pageContent.substring(
								pageMatcher.start(), pageMatcher.end());
						String verComments = "";
						if (textComments.contains(tipComment)) {
							verComments = textComments.substring(0,
									textComments.indexOf(tipComment)).trim();
						} else {
							verComments = textComments.trim();
						}

						if (!verComments.isEmpty()
								|| epicFeatureSummariesChanged) {
							final RemotePageUpdateOptions updateOptions = new RemotePageUpdateOptions();
							if (!verComments.isEmpty()) {
								final String topRevision = this
										.getTopRevision(textComments);
								if (!topRevision.isEmpty()) {
									tipComment = "<p>&nbsp;</p><p>Updated from revision "
											+ topRevision + "</p>";
									page.setContent(storableContent
											+ tipComment);
								} else {
									// will not reach here since topRevision
									// should not be empty
									page.setContent(storableContent
											+ tipComment);
								}
								updateOptions.setVersionComment("\n"
										+ verComments);
							} else {
								page.setContent(storableContent + tipComment);
								updateOptions
										.setVersionComment("\nFeature summaries updated.");
							}
							confluenceClient.updatePage(token, page,
									updateOptions);
						}
					} else {
						// tipComment is not contained in the pageContent
						// meaning package.apt did not exist before
						// the epic page content could be empty or contain only
						// feature
						// summaries
						if (!textComments.isEmpty()
								|| epicFeatureSummariesChanged) {
							final RemotePageUpdateOptions updateOptions = new RemotePageUpdateOptions();
							if (!textComments.isEmpty()) {
								final String topRevision = this
										.getTopRevision(textComments);
								if (!topRevision.isEmpty()) {
									final String tipComment = "<p>&nbsp;</p><p>Updated from revision "
											+ topRevision + "</p>";
									page.setContent(storableContent
											+ tipComment);
								} else {
									// will not reach here since topRevision
									// should not be empty
									page.setContent(storableContent);
								}
								updateOptions.setVersionComment(textComments);
							} else {
								page.setContent(storableContent);
								updateOptions
										.setVersionComment("\nFeature summaries updated.");
							}
							confluenceClient.updatePage(token, page,
									updateOptions);
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
					final RemotePage parentPage = confluenceClient.getPage(
							token, this.spaceKey, parentPageTitle);
					page.setParentId(parentPage.getId());
					page = confluenceClient.storePage(token, page);
				}
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Retrieves the version of the source code that was used to generate a
	 * specific page from Confluence.
	 * 
	 * @param pageTitle
	 *            the title of the page we want the version from
	 * @return the version of source control that this page was generated from,
	 *         or <code>null</code> if the page was not found
	 */
	public String getCurrentPageVersion(final String pageTitle) {
		String pageRevision = null;
		try {
			final P confluenceClient = this.createClient();
			final String token = confluenceClient.login(this.username,
					this.password);
			final RemotePage page;
			try {
				page = confluenceClient
						.getPage(token, this.spaceKey, pageTitle);
				// the page exists in confluence

				// update page based on revision
				final String pageContent = page.getContent();
				final Pattern pattern = Pattern.compile(REVISION_REGEX);
				final Matcher pageMatcher = pattern.matcher(pageContent);

				if (pageMatcher.find()) {
					pageRevision = pageMatcher.group(1);
				} else {
					// will not reach here since revision exists for each
					// features
					this.getLog().warn(
							"Unable to extract the version from page : "
									+ pageTitle);
				}

			} catch (final RemoteException e) {
				// the page does not exist in confluence
			}
		} catch (final Exception e) {
			this.getLog().error(e);
		}
		return pageRevision;
	}

	public Boolean generateConfluenceFeaturePage(final String parentPageTitle,
			final String pageTitle, final String wikiContent,
			final String newPageHistoryLog) {
		boolean featureChanged = false;
		try {
			this.getLog().debug(
					"Working on storing the feature page : " + pageTitle
							+ " in Confluence");
			final P confluenceClient = this.createClient();
			final String token = confluenceClient.login(this.username,
					this.password);
			final String storableContent = this.createStorableContent(
					confluenceClient, token, wikiContent);
			RemotePage page;
			try {
				page = confluenceClient
						.getPage(token, this.spaceKey, pageTitle);
				// the page exists in confluence
				this.getLog().debug(
						"The page has been found in Confluence (id:"
								+ page.getId() + ")");

				// move page to the new parent page if the parent page title
				// changes
				try {
					final Long existingParentPageId = page.getParentId();
					try {
						final RemotePage existingParentPage = confluenceClient
								.getPage(token, existingParentPageId);
						final String existingParentPageTitle = existingParentPage
								.getTitle();

						if (!parentPageTitle.equals(existingParentPageTitle)) {
							this.getLog().info(
									"The parent page has changed, moving from "
											+ existingParentPageTitle + " to "
											+ parentPageTitle);
							final RemotePage newParentPage = confluenceClient
									.getPage(token, this.spaceKey,
											parentPageTitle);
							final Long newParentPageId = newParentPage.getId();
							confluenceClient.movePage(token, page.getId(),
									newParentPageId, "append");
						}
					} catch (final Exception e) {
						this.getLog().info(
								"The parent page did not exist, creating it: "
										+ parentPageTitle);
						final RemotePage newParentPage = confluenceClient
								.getPage(token, this.spaceKey, parentPageTitle);
						confluenceClient.movePage(token, page.getId(),
								newParentPage.getId(), "append");
					}

				} catch (final Exception e) {
					e.printStackTrace();
				}

				// update page based on revision
				final String pageContent = page.getContent();
				final Pattern pattern = Pattern
						.compile(REVISION_REGEX);
				final Matcher pageMatcher = pattern.matcher(pageContent);

				if (pageMatcher.find()) {
					final String pageRevisionInfo = pageMatcher.group(0);
					final String strippedPageHistoryLog;
					this.getLog().debug(
							"TThe new page history log comment is : "
									+ newPageHistoryLog);
					if (newPageHistoryLog.contains(pageRevisionInfo)) {
						strippedPageHistoryLog = newPageHistoryLog.substring(0,
								newPageHistoryLog.indexOf(pageRevisionInfo))
								.trim();
					} else {
						strippedPageHistoryLog = newPageHistoryLog.trim();
					}
					this.getLog().debug(
							"The stripped new page history log comment is : '" + strippedPageHistoryLog
									+ "'");
					if (!strippedPageHistoryLog.isEmpty()) {
						featureChanged = true;
						final RemotePageUpdateOptions updateOptions = new RemotePageUpdateOptions();
						final String topRevision = this
								.getTopRevision(newPageHistoryLog);
						final String newPageRevisionInfo = "<p>&nbsp;</p><p>Updated from revision "
								+ topRevision + "</p>";
						this.getLog().debug(
								"Page updated from revision : " + topRevision);
						page.setContent(storableContent + newPageRevisionInfo);
						updateOptions.setVersionComment("\n" + strippedPageHistoryLog);
						final RemotePage updatedPage = confluenceClient.updatePage(
								token, page, updateOptions);
						this.getLog().debug(
								"The page (" + updatedPage.getTitle()
										+ ")has been updated in Confluence");
					}
				} else {
					// will not reach here since revision exists for each
					// features
					final RemotePageUpdateOptions updateOptions = new RemotePageUpdateOptions();
					final String topRevision = this
							.getTopRevision(newPageHistoryLog);
					final String tipComment = "<p>&nbsp;</p><p>Updated from revision "
							+ topRevision + "</p>";
					page.setContent(storableContent + tipComment);
					updateOptions.setVersionComment(newPageHistoryLog);
					confluenceClient.updatePage(token, page, updateOptions);
				}

			} catch (final RemoteException e) {
				// the page does not exist in confluence
				featureChanged = true;
				page = new RemotePage();

				page.setSpace(this.spaceKey);
				page.setTitle(pageTitle);
				final RemotePage parentPage = confluenceClient.getPage(token,
						this.spaceKey, parentPageTitle);
				page.setParentId(parentPage.getId());
				page = confluenceClient.storePage(token, page);

				final RemotePageUpdateOptions updateOptions = new RemotePageUpdateOptions();
				final String topRevision = this
						.getTopRevision(newPageHistoryLog);
				final String tipComment = "<p>&nbsp;</p><p>Updated from revision "
						+ topRevision + "</p>";
				page.setContent(storableContent + tipComment);
				updateOptions.setVersionComment(newPageHistoryLog);
				confluenceClient.updatePage(token, page, updateOptions);
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}

		return featureChanged;
	}

	protected abstract String createStorableContent(P confluenceClient,
			String token, String wikiContent) throws RemoteException,
			java.rmi.RemoteException;

	private P createClient() {
		return this.createClient(this.confluenceServerRoot);
	}

	protected abstract P createClient(String serverRoot);

	public String getTopRevision(final String textComments) {
		final Pattern pattern = Pattern.compile(REVISION_REGEX);
		final Matcher matcher = pattern.matcher(textComments);

		String topRevision = "";
		if (matcher.find()) {
			topRevision = matcher.group(1);
		}

		return topRevision;
	}

}
