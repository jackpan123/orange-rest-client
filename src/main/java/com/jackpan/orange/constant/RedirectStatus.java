package com.jackpan.orange.constant;

public enum RedirectStatus {

    STATUS301("301"),
    STATUS302("302");
    private String value;

    RedirectStatus(String value) {
        this.value = value;
    }


    /**
     * Gets value.
     *
     * @return Value of value.
     */
    public String getValue() {
        return this.value;
    }
}
