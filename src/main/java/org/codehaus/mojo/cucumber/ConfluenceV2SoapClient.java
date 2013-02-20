package org.codehaus.mojo.cucumber;

import com.atlassian.confluence.rpc.RemoteException;

import confluence.rpc.soap_axis.confluenceservice_v2.ConfluenceSoapServiceProxy;

public class ConfluenceV2SoapClient extends ConfluenceSoapClient<ConfluenceSoapServiceProxy> {

	public ConfluenceV2SoapClient(String username, String password, String spaceKey, String confluenceServerRoot) {
		super(username, password, spaceKey, confluenceServerRoot);
	}

	private static final String ENDPOINT_SUFFIX = "/rpc/soap-axis/confluenceservice-v2";

	@Override
	protected String createStorableContent(ConfluenceSoapServiceProxy p, String token, String wikiContent)
			throws RemoteException, java.rmi.RemoteException {
		return p.convertWikiToStorageFormat(token, wikiContent);
	}

	@Override
	protected ConfluenceSoapServiceProxy createClient(String serverRoot) {
		return new ConfluenceSoapServiceProxy(serverRoot + "/" + ENDPOINT_SUFFIX);
	}

}
