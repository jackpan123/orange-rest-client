package com.jackpan.orange.entity;

import com.jackpan.orange.constant.ConditionType;
import com.jackpan.orange.constant.MatchType;

public class RuleCondition {

    private String type;

    private String operator;

    private String name;

    private String value;

    public RuleCondition() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

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
