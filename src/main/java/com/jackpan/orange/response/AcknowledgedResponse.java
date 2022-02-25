package com.jackpan.orange.response;

import com.alibaba.fastjson.JSONObject;

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

    /**
     * 返回数据
     */
    protected JSONObject data;

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

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
