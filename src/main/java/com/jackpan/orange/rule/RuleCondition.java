package com.jackpan.orange.rule;

public class RuleCondition {

    private String type;

    private String operator;

    private String name;

    private String value;

    private RuleCondition(RuleConditionBuilder builder) {
        this.type = builder.conditionType.getType();
        this.operator = builder.matchType.getOperator();
        this.name = builder.paramName;
        this.value = builder.paramValue;
    }
    public static class RuleConditionBuilder {

        private ConditionType conditionType;

        private MatchType matchType;

        private String paramName;

        private String paramValue;

        private RuleConditionBuilder() {

        }

        public static RuleConditionBuilder builder() {
            return new RuleConditionBuilder();
        }


        public RuleConditionBuilder conditionType(ConditionType conditionType) {
            this.conditionType = conditionType;
            return this;
        }


        public RuleConditionBuilder matchType(MatchType matchType) {
            this.matchType = matchType;
            return this;
        }

        public RuleConditionBuilder paramName(String paramName) {
            this.paramName = paramName;
            return this;
        }

        public RuleConditionBuilder paramValue(String paramValue) {
            this.paramValue = paramValue;
            return this;
        }


        public RuleCondition build() {
            return new RuleCondition(this);
        }

    }



}
