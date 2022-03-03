package com.jackpan.orange.entity.jwt;

/**
 * JWT 规则处理的Handle
 * @author jackpan
 */
public class JwtRuleHandle {


    private JwtCredentials credentials;

    /**
     * 默认401响应码
     */
    private int code = 401;

    /**
     * 默认开启
     */
    private boolean log = true;

    JwtRuleHandle(final JwtCredentials credentials, final int code, final boolean log) {
        this.credentials = credentials;
        this.code = code;
        this.log = log;
    }

    public JwtRuleHandle() {}

    public JwtCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(JwtCredentials credentials) {
        this.credentials = credentials;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isLog() {
        return log;
    }

    public void setLog(boolean log) {
        this.log = log;
    }

    public static JwtRuleHandle.JwtRuleHandleBuilder builder() {
        return new JwtRuleHandle.JwtRuleHandleBuilder();
    }

    public static class JwtRuleHandleBuilder {
        private JwtCredentials credentials;
        private int code;
        private boolean log;

        JwtRuleHandleBuilder() {
        }

        public JwtRuleHandle.JwtRuleHandleBuilder credentials(final JwtCredentials credentials) {
            this.credentials = credentials;
            return this;
        }

        public JwtRuleHandle.JwtRuleHandleBuilder code(final int code) {
            this.code = code;
            return this;
        }

        public JwtRuleHandle.JwtRuleHandleBuilder log(final boolean log) {
            this.log = log;
            return this;
        }

        public JwtRuleHandle build() {
            return new JwtRuleHandle(this.credentials, this.code, this.log);
        }

        public String toString() {
            return "JwtRuleHandle.JwtRuleHandleBuilder(credentials=" + this.credentials + ", code=" + this.code + ", log=" + this.log + ")";
        }
    }
}
