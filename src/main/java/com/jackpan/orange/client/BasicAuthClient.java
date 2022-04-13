package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

/**
 * Basic auth客户端
 * @author jackpan
 */
public class BasicAuthClient extends AbstractClient {

    BasicAuthClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.BASIC_AUTH);
    }

    @Override
    public RuleClient rules(String selectorId) {
        return null;
    }
}