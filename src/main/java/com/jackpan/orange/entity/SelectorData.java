package com.jackpan.orange.entity;


import java.util.Map;

/**
 * @author jackpan
 * @version v1.0 2021/9/14 11:59
 */
public class SelectorData {

    private Boolean enable;

    private Meta meta;

    private Map<String, Selector> selectors;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Map<String, Selector> getSelectors() {
        return selectors;
    }

    public void setSelectors(Map<String, Selector> selectors) {
        this.selectors = selectors;
    }
}
