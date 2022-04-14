package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;
import com.jackpan.orange.entity.redirect.RedirectRule;

/**
 * URL重定向客户端
 * @author jackpan
 */
public class RedirectClient extends AbstractClient {

    private final PluginType pluginType = PluginType.REDIRECT;


    RedirectClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.REDIRECT);
    }

    @Override
    public RuleClient<RedirectRule> rules(String selectorId) {
        return new RedirectRuleClient(orangeRestClient, pluginType, selectorId);
    }
}
