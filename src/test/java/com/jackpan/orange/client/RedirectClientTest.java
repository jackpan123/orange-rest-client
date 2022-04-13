package com.jackpan.orange.client;

import com.jackpan.orange.constant.*;
import com.jackpan.orange.entity.RuleCondition;
import com.jackpan.orange.entity.Selector;
import com.jackpan.orange.entity.SelectorHandle;
import com.jackpan.orange.entity.SelectorRule;
import com.jackpan.orange.entity.jwt.JwtRule;
import com.jackpan.orange.entity.jwt.JwtRuleHandle;
import com.jackpan.orange.entity.rewrite.ParamExtractions;
import com.jackpan.orange.entity.rewrite.ParamExtractor;
import com.jackpan.orange.entity.rewrite.RedirectRuleHandle;
import com.jackpan.orange.response.AcknowledgedResponse;
import com.jackpan.orange.rule.RuleFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RedirectClientTest {

    private OrangeRestClient orangeRestClient;

    @Before
    public void initClient() {
        OrangeRestClientConfig config = new OrangeRestClientConfig();
        config.setServerHost("http://192.168.102.33:7777");
        this.orangeRestClient = new OrangeRestClient(config);
    }



    @Test
    public void redirectPluginTest() {
        // stop plugin
        AcknowledgedResponse stop = orangeRestClient.redirect().plugin().stop();
        if (stop.isAcknowledged()) {
            System.out.println(stop.getMsg());
        }

        AcknowledgedResponse start = orangeRestClient.redirect().plugin().start();
        if (start.isAcknowledged()) {
            System.out.println(start.getMsg());
        }
    }

    /**
     * 测试Orange jwt 选择器接口.
     * Jwt auth module selector test.
     */
    @Test
    public void redirectSelectorListTest() {
        List<Selector> list = orangeRestClient.redirect().selectors().list();
        System.out.println();

    }


    /**
     * 测试创建选择器
     */
    @Test
    public void redirectSelectorCreateTest() {
        // create condition
        RuleCondition.RuleConditionBuilder builder = RuleCondition.RuleConditionBuilder.builder();
        List<RuleCondition> ruleConditions = new ArrayList<>();
        RuleCondition build = builder.conditionType(ConditionType.URI).matchType(MatchType.MATCH).paramValue("/some/api").build();
        ruleConditions.add(build);

        // create rule
        SelectorRule selectorRule = RuleFactory.selectorRule()
                .ruleType(RuleType.SINGLE_CONDITION_MATCH)
                .conditions(ruleConditions).build();

        SelectorHandle handle = SelectorHandle.SelectorHandleBuilder.builder()
                .continueOperation(SelectorHandleType.OMIT_SUBSEQUENT_SELECTORS).log(LogType.LOG).build();

        Selector test3 = Selector.SelectorBuilder.builder().name("test4")
                .type(SelectorType.CUSTOM_TRAFFIC).selectorRule(selectorRule).handle(handle).build();

        AcknowledgedResponse response = orangeRestClient.redirect().selectors().create(test3);
        System.out.println(response.getMsg());

    }

    @Test
    public void redirectSelectorUpdateTest() {
        List<Selector> list = orangeRestClient.redirect().selectors().list();
        if (list.size() > 0) {
            Selector selector = list.get(0);
            selector.setName("customUpdate");
            selector.setType(SelectorType.CUSTOM_TRAFFIC.getType());

            // create condition
            RuleCondition.RuleConditionBuilder builder = RuleCondition.RuleConditionBuilder.builder();
            List<RuleCondition> ruleConditions = new ArrayList<>();
            RuleCondition condition1 = builder.conditionType(ConditionType.URI).matchType(MatchType.MATCH).paramValue("/custom/api").build();
            RuleCondition condition2 = builder.conditionType(ConditionType.HEADER).paramName("customParam").matchType(MatchType.MATCH).paramValue("/custom/api").build();
            ruleConditions.add(condition1);
            ruleConditions.add(condition2);

            // create rule
            SelectorRule selectorRule = RuleFactory.selectorRule()
                    .ruleType(RuleType.AND_MATCH)
                    .conditions(ruleConditions).build();

            selector.setJudge(selectorRule);

            AcknowledgedResponse update = orangeRestClient.redirect().selectors().update(selector);
            System.out.println();
        }
    }

    /**
     * 删除选择器
     */
    @Test
    public void redirectSelectorDeleteTest() {
        List<Selector> list = orangeRestClient.redirect().selectors().list();
        if (list.size() > 0) {
            AcknowledgedResponse delete = orangeRestClient.redirect().selectors().delete(list.get(0).getId());
            System.out.println(delete.getMsg());
        }
    }

    @Test
    public void rewriteRulesCreateTest() {

        // create condition
        RuleCondition.RuleConditionBuilder builder = RuleCondition.RuleConditionBuilder.builder();
        List<RuleCondition> ruleConditions = new ArrayList<>();
        RuleCondition condition1 = builder.conditionType(ConditionType.URI).matchType(MatchType.MATCH).paramValue("/custom/api").build();
        RuleCondition condition2 = builder.conditionType(ConditionType.HEADER).paramName("customParam").matchType(MatchType.MATCH).paramValue("/custom/api").build();
        ruleConditions.add(condition1);
        ruleConditions.add(condition2);

        // create rule
        SelectorRule selectorRule = RuleFactory.selectorRule()
                .ruleType(RuleType.AND_MATCH)
                .conditions(ruleConditions).build();


        ParamExtractions build = ParamExtractions.builder().name("1").type(VariableMatchType.COOKIE).build();
        List<ParamExtractions> paramExtractions = new ArrayList<>();
        paramExtractions.add(build);

        ParamExtractor extractor = ParamExtractor.builder().extractions(paramExtractions).type(VariableExtractionType.INDEX).build();

        RedirectRuleHandle handle = RedirectRuleHandle.builder().url_tmpl("/api/a").trim_qs(TrimQueryType.CLEAN).redirect_status(RedirectStatus.STATUS301).log(LogType.LOG).build();

//        RedirectRule
//
//        JwtRuleHandle handle = JwtRuleHandle.builder().credentials(jwtCredentials).build();
//        JwtRule testRule = JwtRule.builder().name("testRule").judge(selectorRule).handle(handle).build();
//        AcknowledgedResponse response = orangeRestClient.jwtAuth().rules("e2643937-f9be-4ee9-bda3-a931903a252b").create(testRule);
//        System.out.println();
    }


    @Test
    public void jwtAuthRulesListTest() {
        List<JwtRule> list = orangeRestClient.jwtAuth().rules("e2643937-f9be-4ee9-bda3-a931903a252b").list();
        System.out.println();
    }

    // @Test
    public void jwtAuthRulesUpdateTest() {
        List<JwtRule> list = orangeRestClient.jwtAuth().rules("e2643937-f9be-4ee9-bda3-a931903a252b").list();
        if (list.size() > 0) {
            JwtRule rule = list.get(0);
            rule.setName("updateTest");
            AcknowledgedResponse update = orangeRestClient.jwtAuth().rules("e2643937-f9be-4ee9-bda3-a931903a252b").update(rule);
            System.out.println();

        }
    }


    // @Test
    public void jwtAuthRuleDeleteTest() {
        List<JwtRule> list = orangeRestClient.jwtAuth().rules("e2643937-f9be-4ee9-bda3-a931903a252b").list();
        if (list.size() > 0) {
            AcknowledgedResponse delete = orangeRestClient.jwtAuth()
                    .rules("e2643937-f9be-4ee9-bda3-a931903a252b").delete(list.get(0).getId());
            System.out.println(delete.getMsg());
        }
    }

}
