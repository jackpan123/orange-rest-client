package com.jackpan.orange.entity.jwt;

import java.util.List;

public class JwtRuleData {

    private List<JwtRule> rules;

    public JwtRuleData() {
    }

    public List<JwtRule> getRules() {
        return rules;
    }

    public void setRules(List<JwtRule> rules) {
        this.rules = rules;
    }
}
