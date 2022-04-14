package com.jackpan.orange.constant;

public enum EnableType {

    ENABLE(true),
    DISABLE(false);

    EnableType(boolean flag) {
        this.flag = flag;
    }

    private boolean flag;

    public boolean getFlag() {
        return flag;
    }
}
