package com.jackpan.orange.client;

import com.alibaba.fastjson.JSONObject;
import com.jackpan.orange.constant.PluginType;
import com.jackpan.orange.entity.Selector;
import com.jackpan.orange.entity.SelectorData;
import com.jackpan.orange.entity.jwt.JwtRule;
import com.jackpan.orange.entity.jwt.JwtRuleData;
import com.jackpan.orange.request.Request;
import com.jackpan.orange.response.AcknowledgedResponse;

import java.util.ArrayList;
import java.util.List;

public class RuleClient {

    private OrangeRestClient orangeRestClient;

    private PluginType pluginType;

    private String selectorId;

    public RuleClient(OrangeRestClient orangeRestClient, PluginType pluginType, String selectorId) {
        this.orangeRestClient = orangeRestClient;
        this.pluginType = pluginType;
        this.selectorId = selectorId;
    }

    public static RuleClient getInstance(OrangeRestClient orangeRestClient, PluginType pluginType, String selectorId) {
        return new RuleClient(orangeRestClient, pluginType, selectorId);
    }

    public AcknowledgedResponse create(JwtRule rule) {
        Request request = this.createRuleRequest(rule);
        return orangeRestClient.performRequest(request);
    }

    private Request createRuleRequest(JwtRule rule) {
        Request request = new Request("POST", "/" +
                this.pluginType.getValue() + "/selectors/" + this.selectorId + "/rules");
        request.addParameter("rule",  JSONObject.toJSONString(rule));
        return request;
    }

    /**
     * 获取选择器的规则列表
     * @return List<JwtRule>
     */
    public List<JwtRule> list() {
        Request request = this.listRuleRequest();
        AcknowledgedResponse response = orangeRestClient.performRequest(request);
        JSONObject data = response.getData();
        JwtRuleData rule = data.toJavaObject(JwtRuleData.class);
        return rule.getRules();
    }

    private Request listRuleRequest() {
        Request request = new Request("GET", "/" +
                this.pluginType.getValue() + "/selectors/" + this.selectorId + "/rules");
        return request;
    }


    public AcknowledgedResponse update(JwtRule rule) {
        Request request = this.updateRuleRequest(rule);
        return orangeRestClient.performRequest(request);
    }

    private Request updateRuleRequest(JwtRule rule) {
        Request request = new Request("PUT", "/" +
                this.pluginType.getValue() + "/selectors/" + this.selectorId + "/rules");
        request.addParameter("rule",  JSONObject.toJSONString(rule));
        return request;
    }

    /**
     * 删除选择器信息
     * @param ruleId 选择器ID
     * @return AcknowledgedResponse
     */
    public AcknowledgedResponse delete(String ruleId) {
        Request delete = this.deleteSelectorRequest(ruleId);
        return orangeRestClient.performRequest(delete);
    }


    /**
     * 删除选择器Request
     * @param ruleId 选择器信息
     * @return Request
     */
    private Request deleteSelectorRequest(String ruleId) {
        Request request = new Request("DELETE", "/" +
                this.pluginType.getValue() + "/selectors/" + this.selectorId + "/rules");
        request.addParameter("rule_id",  ruleId);
        return request;
    }

}
