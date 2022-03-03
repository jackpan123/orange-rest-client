package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

public class HeadersClient extends AbstractClient {

    HeadersClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.HEADERS);
    }

    @Override
    public RuleClient rules(String selectorId) {
        return null;
    }
}
