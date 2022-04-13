package com.jackpan.orange.constant;

public enum VariableExtractionType {
    INDEX(1),

    TEMPLATE(2);

    VariableExtractionType(Integer type) {
        this.type = type;
    }

    private Integer type;

    public Integer getType() {
        return type;
    }
}
