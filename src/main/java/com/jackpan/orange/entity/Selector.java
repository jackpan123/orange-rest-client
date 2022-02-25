package com.jackpan.orange.entity;


import java.util.List;

/**
 * @author jackpan
 * @version v1.0 2021/9/13 15:15
 */
public class Selector {

    /**
     * 选择器名称
     */
    private String name;

    /**
     * 选择器类型
     */
    private Integer type;

    /**
     * 选择器规则
     */
    private List<Judge> judge;

    /**
     * 处理
     */
    private Handle handle;

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 选择器ID
     */
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Judge> getJudge() {
        return judge;
    }

    public void setJudge(List<Judge> judge) {
        this.judge = judge;
    }

    public Handle getHandle() {
        return handle;
    }

    public void setHandle(Handle handle) {
        this.handle = handle;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
