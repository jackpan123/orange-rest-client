package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

public class RateLimitingClient extends AbstractClient {

    RateLimitingClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.RATE_LIMITING);
    }

    @Override
    public RuleClient rules(String selectorId) {
        return null;
    }
}
