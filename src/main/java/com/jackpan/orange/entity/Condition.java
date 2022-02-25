package com.jackpan.orange.entity;


/**
 * @author jackpan
 * @version v1.0 2021/9/14 11:41
 */
public class Condition {

    private String type;

    private String operator;

    private String name;

    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
