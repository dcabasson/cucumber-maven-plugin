package confluence.rpc.soap_axis.confluenceservice_v2;

public class ConfluenceSoapServiceProxy implements confluence.rpc.soap_axis.confluenceservice_v2.ConfluenceSoapService {
  private String _endpoint = null;
  private confluence.rpc.soap_axis.confluenceservice_v2.ConfluenceSoapService confluenceSoapService = null;
  
  public ConfluenceSoapServiceProxy() {
    _initConfluenceSoapServiceProxy();
  }
  
  public ConfluenceSoapServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initConfluenceSoapServiceProxy();
  }
  
  private void _initConfluenceSoapServiceProxy() {
    try {
      confluenceSoapService = (new confluence.rpc.soap_axis.confluenceservice_v2.ConfluenceSoapServiceServiceLocator()).getConfluenceserviceV2();
      if (confluenceSoapService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)confluenceSoapService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)confluenceSoapService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (confluenceSoapService != null)
      ((javax.xml.rpc.Stub)confluenceSoapService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public confluence.rpc.soap_axis.confluenceservice_v2.ConfluenceSoapService getConfluenceSoapService() {
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService;
  }
  
  public java.lang.String[] getPermissions(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getPermissions(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] search(java.lang.String in0, java.lang.String in1, java.util.HashMap in2, int in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.search(in0, in1, in2, in3);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] search(java.lang.String in0, java.lang.String in1, int in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.search(in0, in1, in2);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpace getSpace(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getSpace(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteComment getComment(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getComment(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteServerInfo getServerInfo(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getServerInfo(in0);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getChildren(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getChildren(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteUser getUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getUser(in0, in1);
  }
  
  public java.lang.String login(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.AuthenticationFailedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.login(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePage getPage(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getPage(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePage getPage(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getPage(in0, in1, in2);
  }
  
  public boolean isPluginEnabled(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.isPluginEnabled(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteClusterInformation getClusterInformation(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getClusterInformation(in0);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteAttachment[] getAttachments(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getAttachments(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteAttachment addAttachment(java.lang.String in0, long in1, com.atlassian.confluence.rpc.soap.beans.RemoteAttachment in2, byte[] in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addAttachment(in0, in1, in2, in3);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteAttachment addAttachment(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteAttachment in1, byte[] in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addAttachment(in0, in1, in2);
  }
  
  public boolean removeAttachment(java.lang.String in0, long in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeAttachment(in0, in1, in2);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteContentPermissionSet getContentPermissionSet(java.lang.String in0, long in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getContentPermissionSet(in0, in1, in2);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteContentPermissionSet[] getContentPermissionSets(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getContentPermissionSets(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteComment[] getComments(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getComments(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteComment addComment(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteComment in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addComment(in0, in1);
  }
  
  public boolean removeComment(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeComment(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getDescendents(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getDescendents(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getAncestors(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getAncestors(in0, in1);
  }
  
  public boolean logout(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.logout(in0);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteAttachment getAttachment(java.lang.String in0, long in1, java.lang.String in2, int in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getAttachment(in0, in1, in2, in3);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getRelatedLabels(java.lang.String in0, java.lang.String in1, int in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getRelatedLabels(in0, in1, in2);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpaceSummary[] getSpaces(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getSpaces(in0);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getPages(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getPages(in0, in1);
  }
  
  public java.lang.String[] getGroups(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getGroups(in0);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePermission[] getPagePermissions(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getPagePermissions(in0, in1);
  }
  
  public boolean setContentPermissions(java.lang.String in0, long in1, java.lang.String in2, com.atlassian.confluence.rpc.soap.beans.RemoteContentPermission[] in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.setContentPermissions(in0, in1, in2, in3);
  }
  
  public boolean moveAttachment(java.lang.String in0, long in1, java.lang.String in2, long in3, java.lang.String in4) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.moveAttachment(in0, in1, in2, in3, in4);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteComment editComment(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteComment in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.editComment(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getTopLevelPages(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getTopLevelPages(in0, in1);
  }
  
  public byte[] getAttachmentData(java.lang.String in0, long in1, java.lang.String in2, int in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getAttachmentData(in0, in1, in2, in3);
  }
  
  public boolean isWatchingSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.isWatchingSpace(in0, in1, in2);
  }
  
  public boolean isWatchingPage(java.lang.String in0, long in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.isWatchingPage(in0, in1, in2);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteContentSummaries getTrashContents(java.lang.String in0, java.lang.String in1, int in2, int in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getTrashContents(in0, in1, in2, in3);
  }
  
  public boolean emptyTrash(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.emptyTrash(in0, in1);
  }
  
  public boolean removeSpace(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeSpace(in0, in1);
  }
  
  public boolean removeUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeUser(in0, in1);
  }
  
  public boolean deactivateUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.deactivateUser(in0, in1);
  }
  
  public boolean reactivateUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.reactivateUser(in0, in1);
  }
  
  public boolean removeGroup(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeGroup(in0, in1, in2);
  }
  
  public boolean removeAllPermissionsForGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeAllPermissionsForGroup(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getRecentlyUsedLabels(java.lang.String in0, int in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getRecentlyUsedLabels(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getRecentlyUsedLabelsInSpace(java.lang.String in0, java.lang.String in1, int in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getRecentlyUsedLabelsInSpace(in0, in1, in2);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getMostPopularLabels(java.lang.String in0, int in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getMostPopularLabels(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getMostPopularLabelsInSpace(java.lang.String in0, java.lang.String in1, int in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getMostPopularLabelsInSpace(in0, in1, in2);
  }
  
  public boolean addGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addGroup(in0, in1);
  }
  
  public void addUser(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteUser in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    confluenceSoapService.addUser(in0, in1, in2);
  }
  
  public boolean addUserToGroup(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addUserToGroup(in0, in1, in2);
  }
  
  public boolean installPlugin(java.lang.String in0, java.lang.String in1, byte[] in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.installPlugin(in0, in1, in2);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup getSpaceGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.AlreadyExistsException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getSpaceGroup(in0, in1);
  }
  
  public java.lang.String[] getPermissionsForUser(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getPermissionsForUser(in0, in1, in2);
  }
  
  public boolean removeSpaceGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeSpaceGroup(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup[] getSpaceGroups(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getSpaceGroups(in0);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getRelatedLabelsInSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2, int in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getRelatedLabelsInSpace(in0, in1, in2, in3);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpace[] getSpacesContainingContentWithLabel(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getSpacesContainingContentWithLabel(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpace[] getSpacesWithLabel(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getSpacesWithLabel(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getLabelsByDetail(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getLabelsByDetail(in0, in1, in2, in3, in4);
  }
  
  public boolean movePageToTopLevel(java.lang.String in0, long in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.movePageToTopLevel(in0, in1, in2);
  }
  
  public java.lang.String renderContent(java.lang.String in0, java.lang.String in1, long in2, java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.renderContent(in0, in1, in2, in3);
  }
  
  public java.lang.String renderContent(java.lang.String in0, java.lang.String in1, long in2, java.lang.String in3, java.util.HashMap in4) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.renderContent(in0, in1, in2, in3, in4);
  }
  
  public java.lang.String exportSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2, boolean in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.exportSpace(in0, in1, in2, in3);
  }
  
  public java.lang.String exportSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.exportSpace(in0, in1, in2);
  }
  
  public boolean removeUserFromGroup(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeUserFromGroup(in0, in1, in2);
  }
  
  public boolean hasUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.hasUser(in0, in1);
  }
  
  public boolean setEnableWysiwyg(java.lang.String in0, boolean in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.setEnableWysiwyg(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpace addSpace(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteSpace in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.AlreadyExistsException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addSpace(in0, in1);
  }
  
  public java.lang.String[] getUserGroups(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getUserGroups(in0, in1);
  }
  
  public boolean isPluginInstalled(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.isPluginInstalled(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePageSummary getPageSummary(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getPageSummary(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePageSummary getPageSummary(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getPageSummary(in0, in1, in2);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePageHistory[] getPageHistory(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getPageHistory(in0, in1);
  }
  
  public boolean movePage(java.lang.String in0, long in1, long in2, java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.movePage(in0, in1, in2, in3);
  }
  
  public boolean removePage(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removePage(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePage storePage(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemotePage in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.VersionMismatchException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.storePage(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemotePage updatePage(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemotePage in1, com.atlassian.confluence.rpc.soap.beans.RemotePageUpdateOptions in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.VersionMismatchException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.updatePage(in0, in1, in2);
  }
  
  public boolean purgeFromTrash(java.lang.String in0, java.lang.String in1, long in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.purgeFromTrash(in0, in1, in2);
  }
  
  public boolean watchPage(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.watchPage(in0, in1);
  }
  
  public boolean watchPageForUser(java.lang.String in0, long in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.watchPageForUser(in0, in1, in2);
  }
  
  public boolean watchSpace(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.watchSpace(in0, in1);
  }
  
  public boolean removePageWatch(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removePageWatch(in0, in1);
  }
  
  public boolean removeSpaceWatch(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeSpaceWatch(in0, in1);
  }
  
  public boolean removePageWatchForUser(java.lang.String in0, long in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removePageWatchForUser(in0, in1, in2);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteUser[] getWatchersForPage(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getWatchersForPage(in0, in1);
  }
  
  public boolean isWatchingSpaceForType(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.isWatchingSpaceForType(in0, in1, in2, in3);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteUser[] getWatchersForSpace(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getWatchersForSpace(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpaceSummary[] getSpacesInGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getSpacesInGroup(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpace addSpaceWithDefaultPermissions(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteSpace in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.AlreadyExistsException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addSpaceWithDefaultPermissions(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpace storeSpace(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteSpace in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.storeSpace(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup addSpaceGroup(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.AlreadyExistsException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addSpaceGroup(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpace addPersonalSpaceWithDefaultPermissions(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteSpace in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.AlreadyExistsException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addPersonalSpaceWithDefaultPermissions(in0, in1, in2);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSpace addPersonalSpace(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteSpace in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.AlreadyExistsException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addPersonalSpace(in0, in1, in2);
  }
  
  public java.lang.String[] getSpaceLevelPermissions(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getSpaceLevelPermissions(in0);
  }
  
  public boolean addPermissionToSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addPermissionToSpace(in0, in1, in2, in3);
  }
  
  public boolean addGlobalPermissions(java.lang.String in0, java.lang.String[] in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addGlobalPermissions(in0, in1, in2);
  }
  
  public boolean addGlobalPermission(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addGlobalPermission(in0, in1, in2);
  }
  
  public boolean addAnonymousUsePermission(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addAnonymousUsePermission(in0);
  }
  
  public boolean addAnonymousViewUserProfilePermission(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addAnonymousViewUserProfilePermission(in0);
  }
  
  public boolean removeAnonymousViewUserProfilePermission(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeAnonymousViewUserProfilePermission(in0);
  }
  
  public boolean removeGlobalPermission(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeGlobalPermission(in0, in1, in2);
  }
  
  public boolean addPermissionsToSpace(java.lang.String in0, java.lang.String[] in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addPermissionsToSpace(in0, in1, in2, in3);
  }
  
  public boolean removePermissionFromSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removePermissionFromSpace(in0, in1, in2, in3);
  }
  
  public boolean editUser(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteUser in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.editUser(in0, in1);
  }
  
  public boolean isActiveUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.isActiveUser(in0, in1);
  }
  
  public java.lang.String[] getActiveUsers(java.lang.String in0, boolean in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getActiveUsers(in0, in1);
  }
  
  public boolean changeMyPassword(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.changeMyPassword(in0, in1, in2);
  }
  
  public boolean changeUserPassword(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.changeUserPassword(in0, in1, in2);
  }
  
  public boolean setUserInformation(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteUserInformation in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.setUserInformation(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteUserInformation getUserInformation(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getUserInformation(in0, in1);
  }
  
  public boolean setUserPreferenceBoolean(java.lang.String in0, java.lang.String in1, java.lang.String in2, boolean in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.setUserPreferenceBoolean(in0, in1, in2, in3);
  }
  
  public boolean getUserPreferenceBoolean(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getUserPreferenceBoolean(in0, in1, in2);
  }
  
  public boolean setUserPreferenceLong(java.lang.String in0, java.lang.String in1, java.lang.String in2, long in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.setUserPreferenceLong(in0, in1, in2, in3);
  }
  
  public long getUserPreferenceLong(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getUserPreferenceLong(in0, in1, in2);
  }
  
  public boolean setUserPreferenceString(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.setUserPreferenceString(in0, in1, in2, in3);
  }
  
  public java.lang.String getUserPreferenceString(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getUserPreferenceString(in0, in1, in2);
  }
  
  public boolean hasGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.hasGroup(in0, in1);
  }
  
  public boolean addProfilePicture(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, byte[] in4) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addProfilePicture(in0, in1, in2, in3, in4);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry getBlogEntryByDayAndTitle(java.lang.String in0, java.lang.String in1, int in2, java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getBlogEntryByDayAndTitle(in0, in1, in2, in3);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry getBlogEntryByDateAndTitle(java.lang.String in0, java.lang.String in1, int in2, int in3, int in4, java.lang.String in5) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getBlogEntryByDateAndTitle(in0, in1, in2, in3, in4, in5);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry getBlogEntry(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getBlogEntry(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntrySummary[] getBlogEntries(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getBlogEntries(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry storeBlogEntry(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.VersionMismatchException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.storeBlogEntry(in0, in1);
  }
  
  public java.lang.String exportSite(java.lang.String in0, boolean in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.exportSite(in0, in1);
  }
  
  public boolean flushIndexQueue(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.flushIndexQueue(in0);
  }
  
  public boolean clearIndexQueue(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.clearIndexQueue(in0);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteNodeStatus[] getClusterNodeStatuses(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getClusterNodeStatuses(in0);
  }
  
  public boolean importSpace(java.lang.String in0, byte[] in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.importSpace(in0, in1);
  }
  
  public boolean setEnableAnonymousAccess(java.lang.String in0, boolean in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.setEnableAnonymousAccess(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getLabelsById(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getLabelsById(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] getLabelContentById(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getLabelContentById(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] getLabelContentByName(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getLabelContentByName(in0, in1);
  }
  
  public com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] getLabelContentByObject(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteLabel in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.getLabelContentByObject(in0, in1);
  }
  
  public boolean addLabelByName(java.lang.String in0, java.lang.String in1, long in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addLabelByName(in0, in1, in2);
  }
  
  public boolean addLabelById(java.lang.String in0, long in1, long in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addLabelById(in0, in1, in2);
  }
  
  public boolean addLabelByObject(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteLabel in1, long in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addLabelByObject(in0, in1, in2);
  }
  
  public boolean addLabelByNameToSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addLabelByNameToSpace(in0, in1, in2);
  }
  
  public boolean removeLabelByName(java.lang.String in0, java.lang.String in1, long in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeLabelByName(in0, in1, in2);
  }
  
  public boolean removeLabelById(java.lang.String in0, long in1, long in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeLabelById(in0, in1, in2);
  }
  
  public boolean removeLabelByObject(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteLabel in1, long in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeLabelByObject(in0, in1, in2);
  }
  
  public boolean removeLabelByNameFromSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeLabelByNameFromSpace(in0, in1, in2);
  }
  
  public boolean removeAnonymousUsePermission(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeAnonymousUsePermission(in0);
  }
  
  public boolean addAnonymousPermissionToSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addAnonymousPermissionToSpace(in0, in1, in2);
  }
  
  public boolean addAnonymousPermissionsToSpace(java.lang.String in0, java.lang.String[] in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.addAnonymousPermissionsToSpace(in0, in1, in2);
  }
  
  public boolean removeAnonymousPermissionFromSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.removeAnonymousPermissionFromSpace(in0, in1, in2);
  }
  
  public java.lang.String convertWikiToStorageFormat(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException{
    if (confluenceSoapService == null)
      _initConfluenceSoapServiceProxy();
    return confluenceSoapService.convertWikiToStorageFormat(in0, in1);
  }
  
  
}