package com.jackpan.orange.constant;

/**
 * 选择器处理类型
 * @author jackpan
 */
public enum SelectorHandleType {

    /**
     * 继续后续选择器
     */
    CONTINUE_SUBSEQUENT_SELECTORS(true),

    /**
     * 省略后续选择器
     */
    OMIT_SUBSEQUENT_SELECTORS(false);

    SelectorHandleType(boolean flag) {
        this.flag = flag;
    }

    private boolean flag;

    public boolean getFlag() {
        return flag;
    }
}
