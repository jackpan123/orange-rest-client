package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

public class WafClient extends AbstractClient {

    WafClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.WAF);
    }

    @Override
    public RuleClient rules(String selectorId) {
        return null;
    }
}
