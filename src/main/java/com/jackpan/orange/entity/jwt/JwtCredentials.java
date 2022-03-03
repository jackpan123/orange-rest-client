package com.jackpan.orange.entity.jwt;

import com.jackpan.orange.entity.Payload;

import java.util.List;

/**
 * JWT验证
 * @author jackpan
 */
public class JwtCredentials {

    /**
     * JWT密钥
     */
    private String secret;

    private List<Payload> payload;

    JwtCredentials(final String secret, final List<Payload> payload) {
        this.secret = secret;
        this.payload = payload;
    }

    public JwtCredentials() {}

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public List<Payload> getPayload() {
        return payload;
    }

    public void setPayload(List<Payload> payload) {
        this.payload = payload;
    }

    public static JwtCredentials.JwtCredentialsBuilder builder() {
        return new JwtCredentials.JwtCredentialsBuilder();
    }

    public static class JwtCredentialsBuilder {
        private String secret;
        private List<Payload> payload;

        JwtCredentialsBuilder() {
        }

        public JwtCredentials.JwtCredentialsBuilder secret(final String secret) {
            this.secret = secret;
            return this;
        }

        public JwtCredentials.JwtCredentialsBuilder payload(final List<Payload> payload) {
            this.payload = payload;
            return this;
        }

        public JwtCredentials build() {
            return new JwtCredentials(this.secret, this.payload);
        }

        public String toString() {
            return "JwtCredentials.JwtCredentialsBuilder(secret=" + this.secret + ", payload=" + this.payload + ")";
        }
    }
}
