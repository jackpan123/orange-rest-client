package com.jackpan.orange.response;

/**
 * 相应值
 * @author jackpan
 */
public class AcknowledgedResponse {



    /**
     * 返回信息
     */
    protected String msg;

    /**
     * 是否成功
     */
    protected boolean success;

    public final boolean isAcknowledged() {
        return success;
    }

    public final String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
