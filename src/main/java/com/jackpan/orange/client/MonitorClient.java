package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

public class MonitorClient extends AbstractClient {

    MonitorClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.MONITOR);
    }

    @Override
    public RuleClient rules(String selectorId) {
        return null;
    }
}
