package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

public abstract class AbstractClient {

    protected OrangeRestClient orangeRestClient;

    protected PluginClient pluginClient;

    protected SelectorClient selectorClient;

    AbstractClient(OrangeRestClient orangeRestClient, PluginType pluginType) {
        this.orangeRestClient = orangeRestClient;
        this.pluginClient = new PluginClient(orangeRestClient, pluginType);
        this.selectorClient = new SelectorClient(orangeRestClient, pluginType);
    }

    public SelectorClient selectors() {
        return selectorClient;
    }

    public abstract RuleClient rules(String selectorId);

    public PluginClient plugin() {
        return pluginClient;
    }
}
