package com.jackpan.orange.constant;

public enum PayloadType {

    HEADER(1);

    PayloadType(int type) {
        this.type = type;
    }

    private int type;

    public int getType() {
        return type;
    }
}
