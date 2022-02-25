package com.jackpan.orange.rule;

import java.nio.channels.Selector;
import java.util.Arrays;
import java.util.List;

public class SelectorRule {


    private RuleType ruleType;

    private List<RuleCondition> conditionList;

    private SelectorRule(SelectorRuleBuilder builder) {
        this.ruleType = builder.ruleType;
        this.conditionList = builder.conditionList;
    }


    public static class SelectorRuleBuilder {

        private RuleType ruleType;

        private List<RuleCondition> conditionList;

        public static SelectorRuleBuilder builder() {
            return new SelectorRuleBuilder();
        }

        private SelectorRuleBuilder() {

        }

        public SelectorRuleBuilder ruleType(RuleType ruleType) {
            this.ruleType = ruleType;
            return this;
        }

        public SelectorRuleBuilder conditions(RuleCondition... ruleConditions) {
            this.conditionList = Arrays.asList(ruleConditions);
            return this;
        }

        public SelectorRule build() {
            SelectorRule selectorRule = new SelectorRule(this);
            return selectorRule;
        }
    }


}
