package com.jackpan.orange.client;

import com.alibaba.fastjson.JSONObject;
import com.jackpan.orange.constant.PluginType;
import com.jackpan.orange.entity.Selector;
import com.jackpan.orange.entity.SelectorData;
import com.jackpan.orange.request.Request;
import com.jackpan.orange.response.AcknowledgedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择器客户端
 * @author jackpan
 */
public class SelectorClient {

    private static final Logger logger = LogManager.getLogger(SelectorClient.class);


    private OrangeRestClient orangeRestClient;

    private PluginType pluginType;

    /**
     * 列表请求
     */
    private Request listRequest;


    SelectorClient(OrangeRestClient orangeRestClient, PluginType pluginType) {
        this.orangeRestClient = orangeRestClient;
        this.pluginType = pluginType;
        this.listRequest = new Request("GET", "/" + pluginType.getValue() + "/selectors");
    }

    public List<Selector> list() {
        AcknowledgedResponse response = orangeRestClient.performRequest(this.listRequest);
        if (!response.isAcknowledged()) {
            logger.error("Get selector list is failed");
            return new ArrayList<>(0);
        }
        JSONObject data = response.getData();
        SelectorData selectorData = data.toJavaObject(SelectorData.class);
        return new ArrayList<>(selectorData.getSelectors().values());
    }
}
