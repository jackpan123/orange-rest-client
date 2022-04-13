package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

/**
 * URL重定向客户端
 * @author jackpan
 */
public class RedirectClient extends AbstractClient {

    RedirectClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.REDIRECT);
    }

    @Override
    public RuleClient rules(String selectorId) {
        return null;
    }
}
