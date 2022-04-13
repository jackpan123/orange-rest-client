package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

/**
 * Signature auth客户端
 * @author jackpan
 */
public class SignatureAuthClient extends AbstractClient {

    SignatureAuthClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.SIGNATURE_AUTH);
    }

    @Override
    public RuleClient rules(String selectorId) {
        return null;
    }
}