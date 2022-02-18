package com.jackpan.orange.client;


import com.jackpan.orange.constant.PluginType;
import com.jackpan.orange.request.Request;
import com.jackpan.orange.response.AcknowledgedResponse;

/**
 * 插件客户端
 *
 * @author jackpan
 */
public class PluginClient {

    private OrangeRestClient orangeRestClient;

    private PluginType pluginType;

    private Request stopRequest;

    private Request startRequest;

    PluginClient(OrangeRestClient orangeRestClient) {
        this.orangeRestClient = orangeRestClient;
    }


    PluginClient(OrangeRestClient orangeRestClient, PluginType pluginType) {
        this.orangeRestClient = orangeRestClient;
        this.pluginType = pluginType;
        this.stopRequest = new Request("POST", "/" + pluginType.getValue() + "/enable");
        stopRequest.addParameter("enable", "0");
        this.startRequest = new Request("POST", "/" + pluginType.getValue() + "/enable");
        startRequest.addParameter("enable", "1");
    }

    public AcknowledgedResponse stop() {
        return orangeRestClient.performRequest(this.stopRequest);
    }


    public AcknowledgedResponse start() {
        return orangeRestClient.performRequest(this.startRequest);
    }
}
