package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;

import java.util.List;

/**
 * 选择器客户端
 * @author jackpan
 */
public class SelectorClient {

    private OrangeRestClient orangeRestClient;

    private PluginType pluginType;
    
    SelectorClient(OrangeRestClient orangeRestClient) {

        this.orangeRestClient = orangeRestClient;
    }

    List<SelectorInfo> list() {


        return null;
    }
}
