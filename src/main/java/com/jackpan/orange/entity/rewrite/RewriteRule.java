package com.jackpan.orange.entity.rewrite;

import com.jackpan.orange.entity.SelectorRule;

/**
 * 重定向验证规则
 * @author jackpan
 */
public class RewriteRule {

    /**
     * 选择器名称
     */
    private String name;

    /**
     * 选择器规则
     */
    private SelectorRule judge;

    /**
     * 变量提取
     */
    private ParamExtractor extractor;

    /**
     * 处理
     */
    private RewriteRuleHandle handle;

    /**
     * 是否启用
     */
    private boolean enable;

    /**
     * 选择器ID
     */
    private String id;
}
