package com.jackpan.orange.constant;

public enum MatchType {

    MATCH("match"),
    NOT_MATCH("not_match"),
    EQUAL("="),
    NOT_EQUAL("!="),
    GRANTER(">"),
    GREATER_THAN(">="),
    LESS("<"),
    LESS_THAN("<="),
    PERCENT("%");

    MatchType(String operator) {
        this.operator = operator;
    }

    private String operator;

    public String getOperator() {
        return operator;
    }
}
