package com.jackpan.orange.entity.redirect;

import com.jackpan.orange.constant.EnableType;
import com.jackpan.orange.entity.SelectorRule;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * 重定向验证规则
 * @author jackpan
 */
@Builder
public class RedirectRule {

    /**
     * 选择器名称
     */
    private String name;

    /**
     * 选择器规则
     */
    private SelectorRule judge;

    /**
     * 变量提取
     */
    private ParamExtractor extractor;

    /**
     * 处理
     */
    private RedirectRuleHandle handle;

    /**
     * 是否启用
     */
    private boolean enable;

    /**
     * 选择器ID
     */
    private String id;

    /**
     * 更新时间
     */
    private LocalDateTime time;

    public RedirectRule() {
    }

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

    public ParamExtractor getExtractor() {
        return extractor;
    }

    public void setExtractor(ParamExtractor extractor) {
        this.extractor = extractor;
    }

    public RedirectRuleHandle getHandle() {
        return handle;
    }

    public void setHandle(RedirectRuleHandle handle) {
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    RedirectRule(String name, SelectorRule judge, ParamExtractor extractor, RedirectRuleHandle handle, EnableType enable, String id) {
        this.name = name;
        this.judge = judge;
        this.extractor = extractor;
        this.handle = handle;
        this.enable = enable.getFlag();
        this.id = id;
    }

    public static RedirectRule.RedirectRuleBuilder builder() {
        return new RedirectRule.RedirectRuleBuilder();
    }

    public static class RedirectRuleBuilder {
        private String name;
        private SelectorRule judge;
        private ParamExtractor extractor;
        private RedirectRuleHandle handle;
        private EnableType enable;
        private String id;

        RedirectRuleBuilder() {
        }

        public RedirectRule.RedirectRuleBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RedirectRule.RedirectRuleBuilder judge(SelectorRule judge) {
            this.judge = judge;
            return this;
        }

        public RedirectRule.RedirectRuleBuilder extractor(ParamExtractor extractor) {
            this.extractor = extractor;
            return this;
        }

        public RedirectRule.RedirectRuleBuilder handle(RedirectRuleHandle handle) {
            this.handle = handle;
            return this;
        }

        public RedirectRule.RedirectRuleBuilder enable(EnableType enable) {
            this.enable = enable;
            return this;
        }

        public RedirectRule.RedirectRuleBuilder id(String id) {
            this.id = id;
            return this;
        }

        public RedirectRule build() {
            return new RedirectRule(this.name, this.judge, this.extractor, this.handle, this.enable, this.id);
        }

        public String toString() {
            return "RedirectRule.RedirectRuleBuilder(name=" + this.name + ", judge=" + this.judge + ", extractor=" + this.extractor + ", handle=" + this.handle + ", enable=" + this.enable + ", id=" + this.id + ")";
        }
    }
}
