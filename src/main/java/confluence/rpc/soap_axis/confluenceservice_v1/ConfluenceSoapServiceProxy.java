package confluence.rpc.soap_axis.confluenceservice_v1;

import confluence.rpc.soap_axis.confluenceservice.ConfluenceServiceProxy;

public class ConfluenceSoapServiceProxy implements confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapService,
        ConfluenceServiceProxy {
    private String _endpoint = null;

    private confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapService confluenceSoapService = null;

    public ConfluenceSoapServiceProxy() {
        _initConfluenceSoapServiceProxy();
    }

    public ConfluenceSoapServiceProxy(String endpoint) {
        _endpoint = endpoint;
        _initConfluenceSoapServiceProxy();
    }

    private void _initConfluenceSoapServiceProxy() {
        try {
            confluenceSoapService = (new confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceServiceLocator())
                    .getConfluenceserviceV1();
            if (confluenceSoapService != null) {
                if (_endpoint != null)
                    ((javax.xml.rpc.Stub) confluenceSoapService)._setProperty("javax.xml.rpc.service.endpoint.address",
                            _endpoint);
                else
                    _endpoint = (String) ((javax.xml.rpc.Stub) confluenceSoapService)
                            ._getProperty("javax.xml.rpc.service.endpoint.address");
            }

        } catch (javax.xml.rpc.ServiceException serviceException) {
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getEndpoint()
     */
    public String getEndpoint() {
        return _endpoint;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#setEndpoint(java
     * .lang.String)
     */
    public void setEndpoint(String endpoint) {
        _endpoint = endpoint;
        if (confluenceSoapService != null)
            ((javax.xml.rpc.Stub) confluenceSoapService)._setProperty("javax.xml.rpc.service.endpoint.address",
                    _endpoint);

    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * getConfluenceSoapService()
     */
    public confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapService getConfluenceSoapService() {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getPermissions(
     * java.lang.String, java.lang.String)
     */
    public java.lang.String[] getPermissions(java.lang.String in0, java.lang.String in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getPermissions(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#search(java.lang
     * .String, java.lang.String, int)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] search(java.lang.String in0,
            java.lang.String in1, int in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.search(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#search(java.lang
     * .String, java.lang.String, java.util.HashMap, int)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] search(java.lang.String in0,
            java.lang.String in1, java.util.HashMap in2, int in3) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.search(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getSpace(java.lang
     * .String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSpace getSpace(java.lang.String in0, java.lang.String in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getSpace(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getComment(java
     * .lang.String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteComment getComment(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getComment(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getServerInfo(java
     * .lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteServerInfo getServerInfo(java.lang.String in0)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getServerInfo(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getChildren(java
     * .lang.String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getChildren(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getChildren(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getUser(java.lang
     * .String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteUser getUser(java.lang.String in0, java.lang.String in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getUser(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#login(java.lang
     * .String, java.lang.String)
     */
    public java.lang.String login(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.AuthenticationFailedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.login(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getPage(java.lang
     * .String, java.lang.String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemotePage getPage(java.lang.String in0, java.lang.String in1,
            java.lang.String in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getPage(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getPage(java.lang
     * .String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemotePage getPage(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getPage(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#isPluginEnabled
     * (java.lang.String, java.lang.String)
     */
    public boolean isPluginEnabled(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.isPluginEnabled(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#installPlugin(java
     * .lang.String, java.lang.String, byte[])
     */
    public boolean installPlugin(java.lang.String in0, java.lang.String in1, byte[] in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.installPlugin(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getClusterInformation
     * (java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteClusterInformation getClusterInformation(java.lang.String in0)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getClusterInformation(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addComment(java
     * .lang.String, com.atlassian.confluence.rpc.soap.beans.RemoteComment)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteComment addComment(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteComment in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addComment(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getComments(java
     * .lang.String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteComment[] getComments(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getComments(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getAttachments(
     * java.lang.String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteAttachment[] getAttachments(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getAttachments(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addAttachment(java
     * .lang.String, long, com.atlassian.confluence.rpc.soap.beans.RemoteAttachment, byte[])
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteAttachment addAttachment(java.lang.String in0, long in1,
            com.atlassian.confluence.rpc.soap.beans.RemoteAttachment in2, byte[] in3) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addAttachment(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addAttachment(java
     * .lang.String, com.atlassian.confluence.rpc.soap.beans.RemoteAttachment, byte[])
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteAttachment addAttachment(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteAttachment in1, byte[] in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addAttachment(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#removeAttachment
     * (java.lang.String, long, java.lang.String)
     */
    public boolean removeAttachment(java.lang.String in0, long in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeAttachment(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getContentPermissionSet
     * (java.lang.String, long, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteContentPermissionSet getContentPermissionSet(
            java.lang.String in0, long in1, java.lang.String in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getContentPermissionSet(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * getContentPermissionSets(java.lang.String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteContentPermissionSet[] getContentPermissionSets(
            java.lang.String in0, long in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getContentPermissionSets(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#removeComment(java
     * .lang.String, long)
     */
    public boolean removeComment(java.lang.String in0, long in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeComment(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getDescendents(
     * java.lang.String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getDescendents(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getDescendents(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getAncestors(java
     * .lang.String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getAncestors(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getAncestors(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#logout(java.lang
     * .String)
     */
    public boolean logout(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.logout(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getAttachment(java
     * .lang.String, long, java.lang.String, int)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteAttachment getAttachment(java.lang.String in0, long in1,
            java.lang.String in2, int in3) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getAttachment(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addUser(java.lang
     * .String, com.atlassian.confluence.rpc.soap.beans.RemoteUser, java.lang.String)
     */
    public void addUser(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteUser in1,
            java.lang.String in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        confluenceSoapService.addUser(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getRelatedLabels
     * (java.lang.String, java.lang.String, int)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getRelatedLabels(java.lang.String in0,
            java.lang.String in1, int in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getRelatedLabels(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getSpaces(java.
     * lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSpaceSummary[] getSpaces(java.lang.String in0)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getSpaces(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getSpaceGroup(java
     * .lang.String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup getSpaceGroup(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.AlreadyExistsException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getSpaceGroup(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getSpaceGroups(
     * java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup[] getSpaceGroups(java.lang.String in0)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getSpaceGroups(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#removeSpace(java
     * .lang.String, java.lang.String)
     */
    public boolean removeSpace(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeSpace(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#convertToPersonalSpace
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)
     */
    public boolean convertToPersonalSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2,
            java.lang.String in3, boolean in4) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.convertToPersonalSpace(in0, in1, in2, in3, in4);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getPages(java.lang
     * .String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getPages(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getPages(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getGroups(java.
     * lang.String)
     */
    public java.lang.String[] getGroups(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getGroups(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#setContentPermissions
     * (java.lang.String, long, java.lang.String,
     * com.atlassian.confluence.rpc.soap.beans.RemoteContentPermission[])
     */
    public boolean setContentPermissions(java.lang.String in0, long in1, java.lang.String in2,
            com.atlassian.confluence.rpc.soap.beans.RemoteContentPermission[] in3) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.setContentPermissions(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#moveAttachment(
     * java.lang.String, long, java.lang.String, long, java.lang.String)
     */
    public boolean moveAttachment(java.lang.String in0, long in1, java.lang.String in2, long in3, java.lang.String in4)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.moveAttachment(in0, in1, in2, in3, in4);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#editComment(java
     * .lang.String, com.atlassian.confluence.rpc.soap.beans.RemoteComment)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteComment editComment(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteComment in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.editComment(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getTopLevelPages
     * (java.lang.String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemotePageSummary[] getTopLevelPages(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getTopLevelPages(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getAttachmentData
     * (java.lang.String, long, java.lang.String, int)
     */
    public byte[] getAttachmentData(java.lang.String in0, long in1, java.lang.String in2, int in3)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getAttachmentData(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#removeUser(java
     * .lang.String, java.lang.String)
     */
    public boolean removeUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeUser(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#deactivateUser(
     * java.lang.String, java.lang.String)
     */
    public boolean deactivateUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.deactivateUser(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#reactivateUser(
     * java.lang.String, java.lang.String)
     */
    public boolean reactivateUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.reactivateUser(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#removeGroup(java
     * .lang.String, java.lang.String, java.lang.String)
     */
    public boolean removeGroup(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeGroup(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addSpace(java.lang
     * .String, com.atlassian.confluence.rpc.soap.beans.RemoteSpace)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSpace addSpace(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteSpace in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.AlreadyExistsException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addSpace(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getRecentlyUsedLabels
     * (java.lang.String, int)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getRecentlyUsedLabels(java.lang.String in0, int in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getRecentlyUsedLabels(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * getRecentlyUsedLabelsInSpace(java.lang.String, java.lang.String, int)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getRecentlyUsedLabelsInSpace(java.lang.String in0,
            java.lang.String in1, int in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getRecentlyUsedLabelsInSpace(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getMostPopularLabels
     * (java.lang.String, int)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getMostPopularLabels(java.lang.String in0, int in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getMostPopularLabels(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * getMostPopularLabelsInSpace(java.lang.String, java.lang.String, int)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getMostPopularLabelsInSpace(java.lang.String in0,
            java.lang.String in1, int in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getMostPopularLabelsInSpace(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#setEnableWysiwyg
     * (java.lang.String, boolean)
     */
    public boolean setEnableWysiwyg(java.lang.String in0, boolean in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.setEnableWysiwyg(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addGroup(java.lang
     * .String, java.lang.String)
     */
    public boolean addGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addGroup(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getPermissionsForUser
     * (java.lang.String, java.lang.String, java.lang.String)
     */
    public java.lang.String[] getPermissionsForUser(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getPermissionsForUser(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * removeAllPermissionsForGroup(java.lang.String, java.lang.String)
     */
    public boolean removeAllPermissionsForGroup(java.lang.String in0, java.lang.String in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeAllPermissionsForGroup(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#removeSpaceGroup
     * (java.lang.String, java.lang.String)
     */
    public boolean removeSpaceGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeSpaceGroup(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getRelatedLabelsInSpace
     * (java.lang.String, java.lang.String, java.lang.String, int)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getRelatedLabelsInSpace(java.lang.String in0,
            java.lang.String in1, java.lang.String in2, int in3) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getRelatedLabelsInSpace(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * getSpacesContainingContentWithLabel(java.lang.String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSpace[] getSpacesContainingContentWithLabel(
            java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getSpacesContainingContentWithLabel(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getSpacesWithLabel
     * (java.lang.String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSpace[] getSpacesWithLabel(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getSpacesWithLabel(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getLabelsByDetail
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getLabelsByDetail(java.lang.String in0,
            java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getLabelsByDetail(in0, in1, in2, in3, in4);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#movePageToTopLevel
     * (java.lang.String, long, java.lang.String)
     */
    public boolean movePageToTopLevel(java.lang.String in0, long in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.movePageToTopLevel(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#movePage(java.lang
     * .String, long, long, java.lang.String)
     */
    public boolean movePage(java.lang.String in0, long in1, long in2, java.lang.String in3)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.movePage(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#renderContent(java
     * .lang.String, java.lang.String, long, java.lang.String)
     */
    public java.lang.String renderContent(java.lang.String in0, java.lang.String in1, long in2, java.lang.String in3)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.renderContent(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#renderContent(java
     * .lang.String, java.lang.String, long, java.lang.String, java.util.HashMap)
     */
    public java.lang.String renderContent(java.lang.String in0, java.lang.String in1, long in2, java.lang.String in3,
            java.util.HashMap in4) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.renderContent(in0, in1, in2, in3, in4);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#exportSpace(java
     * .lang.String, java.lang.String, java.lang.String)
     */
    public java.lang.String exportSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.exportSpace(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#exportSpace(java
     * .lang.String, java.lang.String, java.lang.String, boolean)
     */
    public java.lang.String exportSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2, boolean in3)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.exportSpace(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getUserGroups(java
     * .lang.String, java.lang.String)
     */
    public java.lang.String[] getUserGroups(java.lang.String in0, java.lang.String in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getUserGroups(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getPageHistory(
     * java.lang.String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemotePageHistory[] getPageHistory(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getPageHistory(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#removePage(java
     * .lang.String, long)
     */
    public boolean removePage(java.lang.String in0, long in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removePage(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#storePage(java.
     * lang.String, com.atlassian.confluence.rpc.soap.beans.RemotePage)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemotePage storePage(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemotePage in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.VersionMismatchException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.storePage(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#updatePage(java
     * .lang.String, com.atlassian.confluence.rpc.soap.beans.RemotePage,
     * com.atlassian.confluence.rpc.soap.beans.RemotePageUpdateOptions)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemotePage updatePage(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemotePage in1,
            com.atlassian.confluence.rpc.soap.beans.RemotePageUpdateOptions in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.VersionMismatchException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.updatePage(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getSpacesInGroup
     * (java.lang.String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSpaceSummary[] getSpacesInGroup(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getSpacesInGroup(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#storeSpace(java
     * .lang.String, com.atlassian.confluence.rpc.soap.beans.RemoteSpace)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSpace storeSpace(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteSpace in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.storeSpace(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addSpaceGroup(java
     * .lang.String, com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup addSpaceGroup(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteSpaceGroup in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.AlreadyExistsException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addSpaceGroup(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addPersonalSpace
     * (java.lang.String, com.atlassian.confluence.rpc.soap.beans.RemoteSpace, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSpace addPersonalSpace(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteSpace in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.AlreadyExistsException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addPersonalSpace(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * getSpaceLevelPermissions(java.lang.String)
     */
    public java.lang.String[] getSpaceLevelPermissions(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getSpaceLevelPermissions(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addPermissionToSpace
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addPermissionToSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2,
            java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addPermissionToSpace(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addGlobalPermissions
     * (java.lang.String, java.lang.String[], java.lang.String)
     */
    public boolean addGlobalPermissions(java.lang.String in0, java.lang.String[] in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addGlobalPermissions(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addGlobalPermission
     * (java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addGlobalPermission(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addGlobalPermission(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * addAnonymousUsePermission(java.lang.String)
     */
    public boolean addAnonymousUsePermission(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addAnonymousUsePermission(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * addAnonymousViewUserProfilePermission(java.lang.String)
     */
    public boolean addAnonymousViewUserProfilePermission(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addAnonymousViewUserProfilePermission(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * removeAnonymousViewUserProfilePermission(java.lang.String)
     */
    public boolean removeAnonymousViewUserProfilePermission(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeAnonymousViewUserProfilePermission(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#removeGlobalPermission
     * (java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean removeGlobalPermission(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeGlobalPermission(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addPermissionsToSpace
     * (java.lang.String, java.lang.String[], java.lang.String, java.lang.String)
     */
    public boolean addPermissionsToSpace(java.lang.String in0, java.lang.String[] in1, java.lang.String in2,
            java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addPermissionsToSpace(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * removePermissionFromSpace(java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String)
     */
    public boolean removePermissionFromSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2,
            java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removePermissionFromSpace(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#editUser(java.lang
     * .String, com.atlassian.confluence.rpc.soap.beans.RemoteUser)
     */
    public boolean editUser(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteUser in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.editUser(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addUserToGroup(
     * java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addUserToGroup(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addUserToGroup(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#removeUserFromGroup
     * (java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean removeUserFromGroup(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeUserFromGroup(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getActiveUsers(
     * java.lang.String, boolean)
     */
    public java.lang.String[] getActiveUsers(java.lang.String in0, boolean in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getActiveUsers(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#changeMyPassword
     * (java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean changeMyPassword(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.changeMyPassword(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#changeUserPassword
     * (java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean changeUserPassword(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.changeUserPassword(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#setUserInformation
     * (java.lang.String, com.atlassian.confluence.rpc.soap.beans.RemoteUserInformation)
     */
    public boolean setUserInformation(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteUserInformation in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.setUserInformation(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getUserInformation
     * (java.lang.String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteUserInformation getUserInformation(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getUserInformation(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#hasUser(java.lang
     * .String, java.lang.String)
     */
    public boolean hasUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.hasUser(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#hasGroup(java.lang
     * .String, java.lang.String)
     */
    public boolean hasGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.hasGroup(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addProfilePicture
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String, byte[])
     */
    public boolean addProfilePicture(java.lang.String in0, java.lang.String in1, java.lang.String in2,
            java.lang.String in3, byte[] in4) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addProfilePicture(in0, in1, in2, in3, in4);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * getBlogEntryByDayAndTitle(java.lang.String, java.lang.String, int, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry getBlogEntryByDayAndTitle(java.lang.String in0,
            java.lang.String in1, int in2, java.lang.String in3) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getBlogEntryByDayAndTitle(in0, in1, in2, in3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getBlogEntry(java
     * .lang.String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry getBlogEntry(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getBlogEntry(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getBlogEntries(
     * java.lang.String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntrySummary[] getBlogEntries(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getBlogEntries(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#storeBlogEntry(
     * java.lang.String, com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry storeBlogEntry(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteBlogEntry in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.VersionMismatchException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.storeBlogEntry(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#exportSite(java
     * .lang.String, boolean)
     */
    public java.lang.String exportSite(java.lang.String in0, boolean in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.exportSite(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#flushIndexQueue
     * (java.lang.String)
     */
    public boolean flushIndexQueue(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.flushIndexQueue(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#clearIndexQueue
     * (java.lang.String)
     */
    public boolean clearIndexQueue(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.clearIndexQueue(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getClusterNodeStatuses
     * (java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteNodeStatus[] getClusterNodeStatuses(java.lang.String in0)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getClusterNodeStatuses(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#importSpace(java
     * .lang.String, byte[])
     */
    public boolean importSpace(java.lang.String in0, byte[] in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.importSpace(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * setEnableAnonymousAccess(java.lang.String, boolean)
     */
    public boolean setEnableAnonymousAccess(java.lang.String in0, boolean in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.setEnableAnonymousAccess(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getLabelsById(java
     * .lang.String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteLabel[] getLabelsById(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getLabelsById(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getLabelContentById
     * (java.lang.String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] getLabelContentById(java.lang.String in0,
            long in1) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getLabelContentById(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getLabelContentByName
     * (java.lang.String, java.lang.String)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] getLabelContentByName(java.lang.String in0,
            java.lang.String in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getLabelContentByName(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getLabelContentByObject
     * (java.lang.String, com.atlassian.confluence.rpc.soap.beans.RemoteLabel)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemoteSearchResult[] getLabelContentByObject(java.lang.String in0,
            com.atlassian.confluence.rpc.soap.beans.RemoteLabel in1) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getLabelContentByObject(in0, in1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addLabelByName(
     * java.lang.String, java.lang.String, long)
     */
    public boolean addLabelByName(java.lang.String in0, java.lang.String in1, long in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addLabelByName(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addLabelById(java
     * .lang.String, long, long)
     */
    public boolean addLabelById(java.lang.String in0, long in1, long in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addLabelById(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addLabelByObject
     * (java.lang.String, com.atlassian.confluence.rpc.soap.beans.RemoteLabel, long)
     */
    public boolean addLabelByObject(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteLabel in1,
            long in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addLabelByObject(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#addLabelByNameToSpace
     * (java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addLabelByNameToSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addLabelByNameToSpace(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#removeLabelByName
     * (java.lang.String, java.lang.String, long)
     */
    public boolean removeLabelByName(java.lang.String in0, java.lang.String in1, long in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeLabelByName(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#removeLabelById
     * (java.lang.String, long, long)
     */
    public boolean removeLabelById(java.lang.String in0, long in1, long in2) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.InvalidSessionException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeLabelById(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#removeLabelByObject
     * (java.lang.String, com.atlassian.confluence.rpc.soap.beans.RemoteLabel, long)
     */
    public boolean removeLabelByObject(java.lang.String in0, com.atlassian.confluence.rpc.soap.beans.RemoteLabel in1,
            long in2) throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeLabelByObject(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * removeLabelByNameFromSpace(java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean removeLabelByNameFromSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.NotPermittedException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeLabelByNameFromSpace(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * removeAnonymousUsePermission(java.lang.String)
     */
    public boolean removeAnonymousUsePermission(java.lang.String in0) throws java.rmi.RemoteException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeAnonymousUsePermission(in0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * addAnonymousPermissionToSpace(java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addAnonymousPermissionToSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addAnonymousPermissionToSpace(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * addAnonymousPermissionsToSpace(java.lang.String, java.lang.String[], java.lang.String)
     */
    public boolean addAnonymousPermissionsToSpace(java.lang.String in0, java.lang.String[] in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.addAnonymousPermissionsToSpace(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#
     * removeAnonymousPermissionFromSpace(java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean removeAnonymousPermissionFromSpace(java.lang.String in0, java.lang.String in1, java.lang.String in2)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.NotPermittedException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.removeAnonymousPermissionFromSpace(in0, in1, in2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxyI#getPagePermissions
     * (java.lang.String, long)
     */
    public com.atlassian.confluence.rpc.soap.beans.RemotePermission[] getPagePermissions(java.lang.String in0, long in1)
            throws java.rmi.RemoteException, com.atlassian.confluence.rpc.InvalidSessionException,
            com.atlassian.confluence.rpc.RemoteException {
        if (confluenceSoapService == null)
            _initConfluenceSoapServiceProxy();
        return confluenceSoapService.getPagePermissions(in0, in1);
    }

}