package com.jackpan.orange.rule;

import java.util.Arrays;
import java.util.List;

public class SelectorRule {


    private Integer type;

    private List<RuleCondition> conditions;

    private SelectorRule(SelectorRuleBuilder builder) {
        this.type = builder.ruleType.getType();
        this.conditions = builder.conditionList;
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

        public SelectorRuleBuilder conditions(List<RuleCondition> ruleConditions) {
            this.conditionList = ruleConditions;
            return this;
        }

        public SelectorRule build() {
            if (this.ruleType.equals(RuleType.SINGLE_CONDITION_MATCH) && this.conditionList.size() > 1) {
                throw new IllegalArgumentException("conditionList only have one condition if you choose single condition match rule type");
            }
            return new SelectorRule(this);
        }
    }


}
