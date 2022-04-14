package com.jackpan.orange.entity;


import com.jackpan.orange.constant.EnableType;
import com.jackpan.orange.constant.SelectorType;


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
    private SelectorRule judge;

    /**
     * 处理
     */
    private SelectorHandle handle;

    /**
     * 是否启用
     */
    private boolean enable = true;

    /**
     * 选择器ID
     */
    private String id;

    public Selector() {

    }

    private Selector(SelectorBuilder builder) {
        this.name = builder.name;
        this.type = builder.type.getType();
        this.judge = builder.rule;
        this.handle = builder.handle;
        this.enable = builder.enable.getFlag();
    }

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

    public SelectorRule getJudge() {
        return judge;
    }

    public void setJudge(SelectorRule judge) {
        this.judge = judge;
    }

    public SelectorHandle getHandle() {
        return handle;
    }

    public void setHandle(SelectorHandle handle) {
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

    public static class SelectorBuilder {
        /**
         * 选择器名称
         */
        private String name;

        /**
         * 选择器类型
         */
        private SelectorType type;

        /**
         * 选择器规则
         */
        private SelectorRule rule;

        /**
         * 处理
         */
        private SelectorHandle handle;

        /**
         * 是否启用
         */
        private EnableType enable;

        public static SelectorBuilder builder() {
            return new SelectorBuilder();
        }

        private SelectorBuilder() {

        }

        public SelectorBuilder name(String name) {
            this.name = name;
            return this;
        }


        public SelectorBuilder type(SelectorType type) {
            this.type = type;
            return this;
        }

        public SelectorBuilder selectorRule(SelectorRule rule) {
            this.rule = rule;
            return this;
        }

        public SelectorBuilder handle(SelectorHandle handle) {
            this.handle = handle;
            return this;
        }

        public SelectorBuilder enable(EnableType enable) {
            this.enable = enable;
            return this;
        }


        public Selector build() {
            return new Selector(this);
        }

    }

}
