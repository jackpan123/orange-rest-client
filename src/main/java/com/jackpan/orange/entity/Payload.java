package com.jackpan.orange.entity;

import com.jackpan.orange.constant.PayloadType;

/**
 * Payload 参数
 * @author jackpan
 */
public class Payload {

    private int type = 1;

    private String key;

    private String target_key;

    public Payload() {}


    Payload(final int type, final String key, final String target_key) {
        this.type = type;
        this.key = key;
        this.target_key = target_key;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTarget_key() {
        return target_key;
    }

    public void setTarget_key(String target_key) {
        this.target_key = target_key;
    }

    public static Payload.PayloadBuilder builder() {
        return new Payload.PayloadBuilder();
    }

    public static class PayloadBuilder {
        private int type = PayloadType.HEADER.getType();
        private String key;
        private String target_key;

        PayloadBuilder() {
        }

        public Payload.PayloadBuilder type(PayloadType type) {
            this.type = type.getType();
            return this;
        }

        public Payload.PayloadBuilder key(final String key) {
            this.key = key;
            return this;
        }

        public Payload.PayloadBuilder target_key(final String target_key) {
            this.target_key = target_key;
            return this;
        }

        public Payload build() {
            return new Payload(this.type, this.key, this.target_key);
        }

        public String toString() {
            return "Payload.PayloadBuilder(type=" + this.type + ", key=" + this.key + ", target_key=" + this.target_key + ")";
        }
    }
}
