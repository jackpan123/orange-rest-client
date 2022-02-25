package com.jackpan.orange.entity;


import java.util.List;

/**
 * @author jackpan
 * @version v1.0 2021/9/14 11:46
 */
public class Judge {

    private Integer type;

    private List<Condition> conditions;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}
