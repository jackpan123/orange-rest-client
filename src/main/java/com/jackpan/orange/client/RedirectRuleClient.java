package com.jackpan.orange.client;

import com.alibaba.fastjson.JSONObject;
import com.jackpan.orange.constant.PluginType;
import com.jackpan.orange.entity.redirect.RedirectRule;
import com.jackpan.orange.entity.redirect.RedirectRuleData;
import com.jackpan.orange.request.Request;
import com.jackpan.orange.response.AcknowledgedResponse;

import java.util.List;

public class RedirectRuleClient extends AbstractRuleClient<RedirectRule> {

    public RedirectRuleClient(OrangeRestClient orangeRestClient, PluginType pluginType, String selectorId) {
        this.orangeRestClient = orangeRestClient;
        this.pluginType = pluginType;
        this.selectorId = selectorId;
    }

    public AcknowledgedResponse create(RedirectRule rule) {
        Request request = this.createRuleRequest(JSONObject.toJSONString(rule));
        return orangeRestClient.performRequest(request);
    }


    /**
     * 获取选择器的规则列表
     * @return List<JwtRule>
     */
    public List<RedirectRule> list() {
        Request request = this.listRuleRequest();
        AcknowledgedResponse response = orangeRestClient.performRequest(request);
        JSONObject data = response.getData();
        RedirectRuleData rule = data.toJavaObject(RedirectRuleData.class);
        return rule.getRules();
    }



    public AcknowledgedResponse update(RedirectRule rule) {
        Request request = this.updateRuleRequest(JSONObject.toJSONString(rule));
        return orangeRestClient.performRequest(request);
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


}
