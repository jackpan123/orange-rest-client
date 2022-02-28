package com.jackpan.orange.entity;


import com.jackpan.orange.constant.LogType;
import com.jackpan.orange.constant.SelectorHandleType;

/**
 * @author jackpan
 * @version v1.0 2021/9/14 11:43
 */
public class SelectorHandle {

    /**
     * 默认继续
     */
    private boolean continueOperation = true;

    /**
     * 默认开启
     */
    private boolean log = false;

    public SelectorHandle() {

    }

    SelectorHandle(SelectorHandleBuilder builder) {
        this.continueOperation = builder.continueOperation.getFlag();
        this.log = builder.log.getFlag();
    }


    public Boolean getContinueOperation() {
        return continueOperation;
    }

    public void setContinueOperation(Boolean continueOperation) {
        this.continueOperation = continueOperation;
    }

    public Boolean getLog() {
        return log;
    }

    public void setLog(Boolean log) {
        this.log = log;
    }

    public static class SelectorHandleBuilder {

        private SelectorHandleType continueOperation;

        private LogType log;

        private SelectorHandleBuilder() {}
        public static SelectorHandleBuilder builder() {
            return new SelectorHandleBuilder();
        }

        public SelectorHandleBuilder continueOperation(SelectorHandleType continueOperation) {
            this.continueOperation = continueOperation;
            return this;
        }

        public SelectorHandleBuilder log(LogType log) {
            this.log = log;
            return this;
        }

        public SelectorHandle build() {
            return new SelectorHandle(this);
        }



    }


}
