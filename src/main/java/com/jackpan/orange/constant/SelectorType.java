package com.jackpan.orange.constant;

public enum SelectorType {

    FULL_TRAFFIC(0),
    CUSTOM_TRAFFIC(1);

    SelectorType(Integer type) {
        this.type = type;
    }

    private Integer type;

    public Integer getType() {
        return type;
    }
}
