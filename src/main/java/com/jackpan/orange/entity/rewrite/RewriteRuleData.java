package com.jackpan.orange.entity.rewrite;


import java.util.List;

public class RewriteRuleData {

    private List<RewriteRule> rules;

    public RewriteRuleData() {
    }

    public List<RewriteRule> getRules() {
        return rules;
    }

    public void setRules(List<RewriteRule> rules) {
        this.rules = rules;
    }
}
