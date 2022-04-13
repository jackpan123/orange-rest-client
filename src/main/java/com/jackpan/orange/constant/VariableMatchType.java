package com.jackpan.orange.constant;

public enum VariableMatchType {
    URI("URI"),
    HEADER("Header"),
    QUERY("Query"),
    COOKIE("Cookie"),
    POST_PARAMS("PostParams"),
    IP("IP"),
    HOST("Host"),
    METHOD("Method");

    VariableMatchType(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
