package com.jackpan.orange.constant;

/**
 * @author jackpan
 * @version v1.0 2021/9/14 15:02
 */
public enum PluginType {

    /**
     * 监控插件
     */
    MONITOR("monitor"),
    /**
     * 限速插件
     */
    RATE_LIMITING("rate_limiting"),
    /**
     * 关键词认证插件
     */
    KEY_AUTH("key_auth"),
    /**
     * 基础认证插件
     */
    BASIC_AUTH("basic_auth"),
    /**
     * 基础认证插件
     */
    JWT_AUTH("jwt_auth"),
    /**
     * 代理分流插件
     */
    DIVIDE("divide"),
    /**
     * 统计插件
     */
    STAT("stat"),
    /**
     * waf防火墙插件
     */
    WAF("waf"),
    /**
     * 参数限制插件
     */
    PROPERTY_RATE_LIMITING("property_rate_limiting"),
    /**
     * 重写插件
     */
    REWRITE("rewrite"),
    /**
     * 签名认证插件
     */
    SIGNATURE_AUTH("signature_auth"),
    /**
     * 重定向插件
     */
    REDIRECT("redirect");

    private String value;

    PluginType(String value) {
        this.value = value;
    }


    /**
     * Gets value.
     *
     * @return Value of value.
     */
    public String getValue() {
        return this.value;
    }
}
