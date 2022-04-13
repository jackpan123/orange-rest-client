package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

public class PropertyRateLimitingClient extends AbstractClient {

    PropertyRateLimitingClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.PROPERTY_RATE_LIMITING);
    }

    @Override
    public RuleClient rules(String selectorId) {
        return null;
    }
}
