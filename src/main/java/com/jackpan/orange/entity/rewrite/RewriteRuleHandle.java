package com.jackpan.orange.entity.rewrite;

public class RewriteRuleHandle {

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
}
