package com.jackpan.orange.entity.jwt;

import com.jackpan.orange.entity.SelectorRule;

/**
 * JWT权限验证规则
 * @author jackpan
 */
public class JwtRule {

    /**
     * 选择器名称
     */
    private String name;

    /**
     * 选择器规则
     */
    private SelectorRule judge;

    /**
     * 处理
     */
    private JwtRuleHandle handle;

    /**
     * 是否启用
     */
    private boolean enable;

    /**
     * 选择器ID
     */
    private String id;

    JwtRule(final String name, final SelectorRule judge, final JwtRuleHandle handle, final boolean enable, final String id) {
        this.name = name;
        this.judge = judge;
        this.handle = handle;
        this.enable = enable;
        this.id = id;
    }

    public JwtRule() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SelectorRule getJudge() {
        return judge;
    }

    public void setJudge(SelectorRule judge) {
        this.judge = judge;
    }

    public JwtRuleHandle getHandle() {
        return handle;
    }

    public void setHandle(JwtRuleHandle handle) {
        this.handle = handle;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static JwtRule.JwtRuleBuilder builder() {
        return new JwtRule.JwtRuleBuilder();
    }

    public static class JwtRuleBuilder {
        private String name;
        private SelectorRule judge;
        private JwtRuleHandle handle;
        private boolean enable;
        private String id;

        JwtRuleBuilder() {
        }

        public JwtRule.JwtRuleBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public JwtRule.JwtRuleBuilder judge(final SelectorRule judge) {
            this.judge = judge;
            return this;
        }

        public JwtRule.JwtRuleBuilder handle(final JwtRuleHandle handle) {
            this.handle = handle;
            return this;
        }

        public JwtRule.JwtRuleBuilder enable(final boolean enable) {
            this.enable = enable;
            return this;
        }

        public JwtRule.JwtRuleBuilder id(final String id) {
            this.id = id;
            return this;
        }

        public JwtRule build() {
            return new JwtRule(this.name, this.judge, this.handle, this.enable, this.id);
        }

        public String toString() {
            return "JwtRule.JwtRuleBuilder(name=" + this.name + ", judge=" + this.judge + ", handle=" + this.handle + ", enable=" + this.enable + ", id=" + this.id + ")";
        }
    }
}
