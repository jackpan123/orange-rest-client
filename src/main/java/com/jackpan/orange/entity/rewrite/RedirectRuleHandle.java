package com.jackpan.orange.entity.rewrite;

import com.jackpan.orange.constant.LogType;
import com.jackpan.orange.constant.RedirectStatus;
import com.jackpan.orange.constant.TrimQueryType;
import lombok.Builder;

@Builder
public class RedirectRuleHandle {

    private String url_tmpl;

    private boolean trim_qs;

    private String redirect_status;

    private boolean log;

    public String getUrl_tmpl() {
        return url_tmpl;
    }

    public void setUrl_tmpl(String url_tmpl) {
        this.url_tmpl = url_tmpl;
    }

    public boolean isTrim_qs() {
        return trim_qs;
    }

    public void setTrim_qs(boolean trim_qs) {
        this.trim_qs = trim_qs;
    }

    public String getRedirect_status() {
        return redirect_status;
    }

    public void setRedirect_status(String redirect_status) {
        this.redirect_status = redirect_status;
    }

    public boolean isLog() {
        return log;
    }

    public void setLog(boolean log) {
        this.log = log;
    }

    RedirectRuleHandle(String url_tmpl, TrimQueryType trim_qs, RedirectStatus redirect_status, LogType log) {
        this.url_tmpl = url_tmpl;
        this.trim_qs = trim_qs.getFlag();
        this.redirect_status = redirect_status.getValue();
        this.log = log.getFlag();
    }

    public static RedirectRuleHandle.RewriteRuleHandleBuilder builder() {
        return new RedirectRuleHandle.RewriteRuleHandleBuilder();
    }

    public static class RewriteRuleHandleBuilder {
        private String url_tmpl;
        private TrimQueryType trim_qs;
        private RedirectStatus redirect_status;
        private LogType log;

        RewriteRuleHandleBuilder() {
        }

        public RedirectRuleHandle.RewriteRuleHandleBuilder url_tmpl(String url_tmpl) {
            this.url_tmpl = url_tmpl;
            return this;
        }

        public RedirectRuleHandle.RewriteRuleHandleBuilder trim_qs(TrimQueryType trim_qs) {
            this.trim_qs = trim_qs;
            return this;
        }

        public RedirectRuleHandle.RewriteRuleHandleBuilder redirect_status(RedirectStatus redirect_status) {
            this.redirect_status = redirect_status;
            return this;
        }

        public RedirectRuleHandle.RewriteRuleHandleBuilder log(LogType log) {
            this.log = log;
            return this;
        }

        public RedirectRuleHandle build() {
            return new RedirectRuleHandle(this.url_tmpl, this.trim_qs, this.redirect_status, this.log);
        }

        public String toString() {
            return "RewriteRuleHandle.RewriteRuleHandleBuilder(url_tmpl=" + this.url_tmpl + ", trim_qs=" + this.trim_qs + ", redirect_status=" + this.redirect_status + ", log=" + this.log + ")";
        }
    }
}
