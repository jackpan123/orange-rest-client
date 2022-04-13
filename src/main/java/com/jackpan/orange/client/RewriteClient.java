package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

public class RewriteClient extends AbstractClient {

    private final PluginType pluginType = PluginType.REWRITE;

    RewriteClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.REWRITE);
    }

    @Override
    public RuleClient rules(String selectorId) {
        return new JwtRuleClient(orangeRestClient, pluginType, selectorId);
    }
}
