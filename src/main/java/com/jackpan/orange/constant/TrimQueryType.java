package com.jackpan.orange.constant;

public enum TrimQueryType {

    CLEAN(true),
    NOT_CLEAN(false);

    TrimQueryType(boolean flag) {
        this.flag = flag;
    }

    private boolean flag;

    public boolean getFlag() {
        return flag;
    }
}
