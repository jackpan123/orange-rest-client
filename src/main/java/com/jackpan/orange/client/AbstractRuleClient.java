package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;
import com.jackpan.orange.request.Request;


public abstract class AbstractRuleClient<E> implements RuleClient<E> {

    protected OrangeRestClient orangeRestClient;

    protected PluginType pluginType;

    protected String selectorId;

    protected Request createRuleRequest(String ruleString) {
        Request request = new Request("POST", "/" +
                this.pluginType.getValue() + "/selectors/" + this.selectorId + "/rules");
        request.addParameter("rule",  ruleString);
        return request;
    }

    protected Request listRuleRequest() {
        Request request = new Request("GET", "/" +
                this.pluginType.getValue() + "/selectors/" + this.selectorId + "/rules");
        return request;
    }

    protected Request updateRuleRequest(String ruleString) {
        Request request = new Request("PUT", "/" +
                this.pluginType.getValue() + "/selectors/" + this.selectorId + "/rules");
        request.addParameter("rule",  ruleString);
        return request;
    }

    /**
     * 删除选择器Request
     * @param ruleId 选择器信息
     * @return Request
     */
    protected Request deleteSelectorRequest(String ruleId) {
        Request request = new Request("DELETE", "/" +
                this.pluginType.getValue() + "/selectors/" + this.selectorId + "/rules");
        request.addParameter("rule_id",  ruleId);
        return request;
    }
}
