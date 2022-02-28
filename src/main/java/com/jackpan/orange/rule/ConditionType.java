package com.jackpan.orange.rule;

public enum ConditionType {

    RANDOM("Random"),
    URI("URI"),
    HEADER("Header"),
    QUERY("Query"),
    COOKIE("Cookie"),
    POST_PARAMS("PostParams"),
    IP("IP"),
    USER_AGENT("UserAgent"),
    HOST("Host"),
    REFERER("Referer"),
    HTTP_METHOD("Method");

    ConditionType(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}