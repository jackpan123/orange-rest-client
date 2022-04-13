package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

/**
 * Key auth客户端
 * @author jackpan
 */
public class KeyAuthClient extends AbstractClient {

    KeyAuthClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.KEY_AUTH);
    }

    @Override
    public RuleClient rules(String selectorId) {
        return null;
    }
}