package com.jackpan.orange.constant;

public enum RuleType {

    SINGLE_CONDITION_MATCH(0),

    AND_MATCH(1),

    OR_MATCH(2),

    COMPLEX_MATCH(3);

    RuleType(Integer type) {
        this.type = type;
    }

    private Integer type;

    public Integer getType() {
        return type;
    }
}
