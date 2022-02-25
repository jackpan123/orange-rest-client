package com.jackpan.orange.entity;


import java.util.List;
import java.util.Map;

/**
 * @author jackpan
 * @version v1.0 2021/9/13 15:12
 */
public class DivideSelectorInfo {

    /**
     * 该插件所有选择器元数据ID
     */
    private List<String> selectorMeta;

    private Map<String, Selector> selectorMap;

    public List<String> getSelectorMeta() {
        return selectorMeta;
    }

    public void setSelectorMeta(List<String> selectorMeta) {
        this.selectorMeta = selectorMeta;
    }

    public Map<String, Selector> getSelectorMap() {
        return selectorMap;
    }

    public void setSelectorMap(Map<String, Selector> selectorMap) {
        this.selectorMap = selectorMap;
    }
}
