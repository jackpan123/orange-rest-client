package com.jackpan.orange.client;

import com.jackpan.orange.constant.PluginType;
import com.jackpan.orange.entity.jwt.JwtRule;

/**
 * Jwt 验证客户端。
 * @author jackpan
 */
public class JwtAuthClient extends AbstractClient{

    private final PluginType pluginType = PluginType.JWT_AUTH;

    JwtAuthClient(OrangeRestClient orangeRestClient) {
        super(orangeRestClient, PluginType.JWT_AUTH);
    }

    public RuleClient<JwtRule> rules(String selectorId) {
        return new JwtRuleClient(orangeRestClient, pluginType, selectorId);
    }
}
