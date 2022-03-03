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
        this.listRequest = new Request("GET", "/" + this.pluginType.getValue() + "/selectors");
    }

    /**
     * 获取选择器的列表
     * @return List<Selector>
     */
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

    /**
     * 创建选择器
     * @param selector 选择器信息
     * @return AcknowledgedResponse
     */
    public AcknowledgedResponse create(Selector selector) {
        Request createRequest = this.createSelectorRequest(selector);
        return orangeRestClient.performRequest(createRequest);
    }

    private Request createSelectorRequest(Selector selector) {
        Request request = new Request("POST", "/" + this.pluginType.getValue() + "/selectors");
        request.addParameter("selector",  JSONObject.toJSONString(selector));
        return request;
    }

    /**
     * 更新选择器信息
     * @param selector 选择器信息，需要包含选择器ID
     * @return AcknowledgedResponse
     */
    public AcknowledgedResponse update(Selector selector) {
        if (selector.getId() == null || "".equals(selector.getId())) {
            throw new IllegalArgumentException("Selector id must not be null");
        }
        Request update = this.updateSelectorRequest(selector);
        return orangeRestClient.performRequest(update);
    }

    /**
     * 更新选择器Request
     * @param selector 选择器信息
     * @return Request
     */
    private Request updateSelectorRequest(Selector selector) {
        Request request = new Request("PUT", "/" + this.pluginType.getValue() + "/selectors");
        request.addParameter("selector",  JSONObject.toJSONString(selector));
        return request;
    }






}
