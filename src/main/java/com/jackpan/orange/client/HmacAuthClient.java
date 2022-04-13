package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

/**
 * Hmac auth客户端
 * @author jackpan
 */
public class HmacAuthClient extends AbstractClient {

    HmacAuthClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.HMAC_AUTH);
    }

    @Override
    public RuleClient rules(String selectorId) {
        return null;
    }
}