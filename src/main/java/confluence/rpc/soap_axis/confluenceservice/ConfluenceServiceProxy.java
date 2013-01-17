package confluence.rpc.soap_axis.confluenceservice;

/**
 * Interface extracted from common methods in v1 and v2 confluence service proxies. Created to ease
 * backward compatibility for confluence soap service v1.
 * 
 * @author cfenwick
 * 
 */
public interface ConfluenceServiceProxy {

    public abstract String getEndpoint();

    public abstract void setEndpoint(String endpoint);

    public abstract java.lang.String[] getPermissions(java.lang.String in0, java.lang.String in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] search(java.lang.String in0,
            java.lang.String in1, int in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] search(java.lang.String in0,
            java.lang.String in1, java.util.HashMap in2, int in3) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSpace getSpace(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteComment getComment(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteServerInfo getServerInfo(java.lang.String in0)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getChildren(java.lang.String in0,
            long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteUser getUser(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract java.lang.String login(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.AuthenticationFailedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemotePage getPage(java.lang.String in0,
            java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemotePage getPage(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean isPluginEnabled(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;

    public abstract boolean installPlugin(java.lang.String in0, java.lang.String in1, byte[] in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteClusterInformation getClusterInformation(
            java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteComment addComment(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteComment in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteComment[] getComments(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteAttachment[] getAttachments(java.lang.String in0,
            long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteAttachment addAttachment(java.lang.String in0,
            long in1, com.atlassian.confluence.rpc.soap.beans.RemoteAttachment in2, byte[] in3)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteAttachment addAttachment(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteAttachment in1, byte[] in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeAttachment(java.lang.String in0, long in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteContentPermissionSet getContentPermissionSet(
            java.lang.String in0, long in1, java.lang.String in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteContentPermissionSet[] getContentPermissionSets(
            java.lang.String in0, long in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeComment(java.lang.String in0, long in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getDescendents(java.lang.String in0,
            long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getAncestors(java.lang.String in0,
            long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean logout(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteAttachment getAttachment(java.lang.String in0,
            long in1, java.lang.String in2, int in3) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract void addUser(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteUser in1,
            java.lang.String in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getRelatedLabels(java.lang.String in0,
            java.lang.String in1, int in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSpaceSummary[] getSpaces(java.lang.String in0)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup getSpaceGroup(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.AlreadyExistsException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup[] getSpaceGroups(java.lang.String in0)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeSpace(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getPages(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract java.lang.String[] getGroups(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean setContentPermissions(java.lang.String in0, long in1, java.lang.String in2,
            com.atlassian.confluence.rpc.soap.beans.RemoteContentPermission[] in3) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean moveAttachment(java.lang.String in0, long in1, java.lang.String in2, long in3,
            java.lang.String in4) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteComment editComment(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteComment in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getTopLevelPages(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract byte[] getAttachmentData(java.lang.String in0, long in1, java.lang.String in2, int in3)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean deactivateUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean reactivateUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeGroup(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSpace addSpace(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteSpace in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.AlreadyExistsException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getRecentlyUsedLabels(java.lang.String in0,
            int in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getRecentlyUsedLabelsInSpace(
            java.lang.String in0, java.lang.String in1, int in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getMostPopularLabels(java.lang.String in0,
            int in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getMostPopularLabelsInSpace(
            java.lang.String in0, java.lang.String in1, int in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean setEnableWysiwyg(java.lang.String in0, boolean in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract java.lang.String[] getPermissionsForUser(java.lang.String in0, java.lang.String in1,
            java.lang.String in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeAllPermissionsForGroup(java.lang.String in0, java.lang.String in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeSpaceGroup(java.lang.String in0, java.lang.String in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getRelatedLabelsInSpace(java.lang.String in0,
            java.lang.String in1, java.lang.String in2, int in3) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSpace[] getSpacesContainingContentWithLabel(
            java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSpace[] getSpacesWithLabel(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getLabelsByDetail(java.lang.String in0,
            java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean movePageToTopLevel(java.lang.String in0, long in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean movePage(java.lang.String in0, long in1, long in2, java.lang.String in3)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract java.lang.String renderContent(java.lang.String in0, java.lang.String in1, long in2,
            java.lang.String in3) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract java.lang.String renderContent(java.lang.String in0, java.lang.String in1, long in2,
            java.lang.String in3, java.util.HashMap in4) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract java.lang.String exportSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract java.lang.String exportSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2,
            boolean in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract java.lang.String[] getUserGroups(java.lang.String in0, java.lang.String in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemotePageHistory[] getPageHistory(java.lang.String in0,
            long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removePage(java.lang.String in0, long in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemotePage storePage(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemotePage in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.VersionMismatchException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemotePage updatePage(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemotePage in1,
            com.atlassian.confluence.rpc.soap.beans.RemotePageUpdateOptions in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.VersionMismatchException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSpaceSummary[] getSpacesInGroup(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSpace storeSpace(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteSpace in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup addSpaceGroup(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.AlreadyExistsException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSpace addPersonalSpace(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteSpace in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.AlreadyExistsException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract java.lang.String[] getSpaceLevelPermissions(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addPermissionToSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2,
            java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addGlobalPermissions(java.lang.String in0, java.lang.String[] in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addGlobalPermission(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addAnonymousUsePermission(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addAnonymousViewUserProfilePermission(java.lang.String in0)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeAnonymousViewUserProfilePermission(java.lang.String in0)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeGlobalPermission(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addPermissionsToSpace(java.lang.String in0, java.lang.String[] in1, java.lang.String in2,
            java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removePermissionFromSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2,
            java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean editUser(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteUser in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addUserToGroup(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeUserFromGroup(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract java.lang.String[] getActiveUsers(java.lang.String in0, boolean in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean changeMyPassword(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean changeUserPassword(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean setUserInformation(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteUserInformation in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteUserInformation getUserInformation(
            java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean hasUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean hasGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addProfilePicture(java.lang.String in0, java.lang.String in1, java.lang.String in2,
            java.lang.String in3, byte[] in4) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry getBlogEntryByDayAndTitle(
            java.lang.String in0, java.lang.String in1, int in2, java.lang.String in3) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry getBlogEntry(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntrySummary[] getBlogEntries(
            java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry storeBlogEntry(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.VersionMismatchException, com.atlassian.confluence.rpc.RemoteException;

    public abstract java.lang.String exportSite(java.lang.String in0, boolean in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean flushIndexQueue(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean clearIndexQueue(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteNodeStatus[] getClusterNodeStatuses(
            java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean importSpace(java.lang.String in0, byte[] in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean setEnableAnonymousAccess(java.lang.String in0, boolean in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getLabelsById(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] getLabelContentById(
            java.lang.String in0, long in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] getLabelContentByName(
            java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] getLabelContentByObject(
            java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteLabel in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addLabelByName(java.lang.String in0, java.lang.String in1, long in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addLabelById(java.lang.String in0, long in1, long in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addLabelByObject(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteLabel in1, long in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addLabelByNameToSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeLabelByName(java.lang.String in0, java.lang.String in1, long in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeLabelById(java.lang.String in0, long in1, long in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeLabelByObject(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteLabel in1, long in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeLabelByNameFromSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeAnonymousUsePermission(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addAnonymousPermissionToSpace(java.lang.String in0, java.lang.String in1,
            java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean addAnonymousPermissionsToSpace(java.lang.String in0, java.lang.String[] in1,
            java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException;

    public abstract boolean removeAnonymousPermissionFromSpace(java.lang.String in0, java.lang.String in1,
            java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException;

    public abstract com.atlassian.confluence.rpc.soap.beans.RemotePermission[] getPagePermissions(java.lang.String in0,
            long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException;

}