package com.jackpan.orange.entity.rewrite;


import java.util.List;

public class RedirectRuleData {

    private List<RedirectRule> rules;

    public RedirectRuleData() {
    }

    public List<RedirectRule> getRules() {
        return rules;
    }

    public void setRules(List<RedirectRule> rules) {
        this.rules = rules;
    }
}
