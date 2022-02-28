package com.jackpan.orange.constant;

public enum LogType {

    LOG(true),
    NOT_LOG(false);

    LogType(boolean flag) {
        this.flag = flag;
    }

    private boolean flag;

    public boolean getFlag() {
        return flag;
    }
}
