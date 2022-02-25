package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

/**
 * Jwt 验证客户端。
 * @author jackpan
 */
public class JwtAuthClient {

    private OrangeRestClient orangeRestClient;

    private final PluginType pluginType = PluginType.JWT_AUTH;

    private PluginClient pluginClient;

    private SelectorClient selectorClient;
    JwtAuthClient(OrangeRestClient orangeRestClient) {
        this.orangeRestClient = orangeRestClient;
        this.pluginClient = new PluginClient(orangeRestClient, pluginType);
        this.selectorClient = new SelectorClient(orangeRestClient, pluginType);
    }

    public SelectorClient selectors() {
        return selectorClient;
    }

    public PluginClient plugin() {
        return pluginClient;
    }
}
