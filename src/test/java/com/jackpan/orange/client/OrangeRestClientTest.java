package com.jackpan.orange.client;

import com.jackpan.orange.constant.*;
import com.jackpan.orange.entity.*;
import com.jackpan.orange.entity.jwt.JwtCredentials;
import com.jackpan.orange.entity.jwt.JwtRule;
import com.jackpan.orange.entity.jwt.JwtRuleHandle;
import com.jackpan.orange.response.AcknowledgedResponse;
import com.jackpan.orange.rule.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrangeRestClientTest {

    private OrangeRestClient orangeRestClient;

    @Before
    public void initClient() {
        OrangeRestClientConfig config = new OrangeRestClientConfig();
        config.setServerHost("http://192.168.102.33:7777");
        this.orangeRestClient = new OrangeRestClient(config);
    }


    //@Test
    public void jwtAuthPluginTest() {
        // stop plugin
        AcknowledgedResponse stop = orangeRestClient.jwtAuth().plugin().stop();
        if (stop.isAcknowledged()) {
            System.out.println(stop.getMsg());
        }

        AcknowledgedResponse start = orangeRestClient.jwtAuth().plugin().start();
        if (start.isAcknowledged()) {
            System.out.println(start.getMsg());
        }
    }

    /**
     * 测试Orange jwt 选择器接口.
     * Jwt auth module selector test.
     */
    // @Test
    public void jwtAuthSelectorListTest() {
        List<Selector> list = orangeRestClient.jwtAuth().selectors().list();

    }

    /**
     * 测试创建选择器
     */
    //@Test
    public void jwtAuthSelectorCreateTest() {
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

        AcknowledgedResponse response = orangeRestClient.jwtAuth().selectors().create(test3);
        System.out.println(response.getMsg());

    }

    //@Test
    public void jwtAuthSelectorUpdateTest() {
        List<Selector> list = orangeRestClient.jwtAuth().selectors().list();
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

            AcknowledgedResponse update = orangeRestClient.jwtAuth().selectors().update(selector);
            System.out.println();
        }
    }

    /**
     * 删除选择器
     */
    // @Test
    public void jwtAuthSelectorDeleteTest() {
        List<Selector> list = orangeRestClient.jwtAuth().selectors().list();
        if (list.size() > 0) {
            AcknowledgedResponse delete = orangeRestClient.jwtAuth().selectors().delete(list.get(0).getId());
            System.out.println(delete.getMsg());
        }
    }

    @Test
    public void jwtAuthRulesCreateTest() {

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


        Payload build = Payload.builder().key("aaa").target_key("bb").build();
        List<Payload> payloads = new ArrayList<>();
        payloads.add(build);

        JwtCredentials jwtCredentials = JwtCredentials.builder().payload(payloads).secret("ccc").build();

        JwtRuleHandle handle = JwtRuleHandle.builder().credentials(jwtCredentials).build();
        JwtRule testRule = JwtRule.builder().name("testRule").judge(selectorRule).handle(handle).build();
        AcknowledgedResponse response = orangeRestClient.jwtAuth().rules("e2643937-f9be-4ee9-bda3-a931903a252b").create(testRule);
        System.out.println();
    }


}
