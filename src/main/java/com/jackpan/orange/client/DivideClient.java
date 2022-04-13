package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

public class DivideClient extends AbstractClient {

    DivideClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.DIVIDE);
    }

    @Override
    public RuleClient rules(String selectorId) {
        return null;
    }
}
