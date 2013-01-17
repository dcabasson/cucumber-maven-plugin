package org.codehaus.mojo.cucumber;

import confluence.rpc.soap_axis.confluenceservice_v1.ConfluenceSoapServiceProxy;

public class ConfluenceV1SoapClient extends ConfluenceSoapClient<ConfluenceSoapServiceProxy> {

    public ConfluenceV1SoapClient(String username, String password, String spaceKey, String confluenceServerRoot) {
        super(username, password, spaceKey, confluenceServerRoot);
    }

    private static final String ENDPOINT_SUFFIX = "/rpc/soap-axis/confluenceservice-v1";

    @Override
    protected String createStorableContent(ConfluenceSoapServiceProxy p, String token, String wikiContent) {
        // Do nothing, version 1 stores wiki content as-is
        return wikiContent;
    }

    @Override
    protected ConfluenceSoapServiceProxy createClient(String serverRoot) {
        return new ConfluenceSoapServiceProxy(serverRoot + "/" + ENDPOINT_SUFFIX);
    }

}
