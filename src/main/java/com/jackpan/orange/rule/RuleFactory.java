package com.jackpan.orange.rule;

import com.jackpan.orange.entity.SelectorRule;

/**
 * 规则工厂
 * @author jackpan
 */
public class RuleFactory {


    private RuleFactory() {}
    public static SelectorRule.SelectorRuleBuilder selectorRule() {
        return SelectorRule.SelectorRuleBuilder.builder();
    }

}
