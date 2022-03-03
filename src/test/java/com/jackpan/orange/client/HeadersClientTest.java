package com.jackpan.orange.client;

import com.jackpan.orange.constant.*;
import com.jackpan.orange.entity.RuleCondition;
import com.jackpan.orange.entity.Selector;
import com.jackpan.orange.entity.SelectorHandle;
import com.jackpan.orange.entity.SelectorRule;
import com.jackpan.orange.response.AcknowledgedResponse;
import com.jackpan.orange.rule.RuleFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HeadersClientTest {

    private OrangeRestClient orangeRestClient;

    @Before
    public void initClient() {
        OrangeRestClientConfig config = new OrangeRestClientConfig();
        config.setServerHost("http://192.168.102.33:7777");
        this.orangeRestClient = new OrangeRestClient(config);
    }



    // @Test
    public void headersPluginTest() {
        // stop plugin
        AcknowledgedResponse stop = orangeRestClient.headers().plugin().stop();
        if (stop.isAcknowledged()) {
            System.out.println(stop.getMsg());
        }

        AcknowledgedResponse start = orangeRestClient.headers().plugin().start();
        if (start.isAcknowledged()) {
            System.out.println(start.getMsg());
        }
    }

    /**
     * 测试Orange jwt 选择器接口.
     * Jwt auth module selector test.
     */
    @Test
    public void headersSelectorListTest() {
        List<Selector> list = orangeRestClient.headers().selectors().list();
        System.out.println();

    }


    /**
     * 测试创建选择器
     */
    @Test
    public void headersSelectorCreateTest() {
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

        AcknowledgedResponse response = orangeRestClient.headers().selectors().create(test3);
        System.out.println(response.getMsg());

    }

    @Test
    public void headersSelectorUpdateTest() {
        List<Selector> list = orangeRestClient.headers().selectors().list();
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

            AcknowledgedResponse update = orangeRestClient.headers().selectors().update(selector);
            System.out.println();
        }
    }

    /**
     * 删除选择器
     */
    @Test
    public void headersSelectorDeleteTest() {
        List<Selector> list = orangeRestClient.headers().selectors().list();
        if (list.size() > 0) {
            AcknowledgedResponse delete = orangeRestClient.headers().selectors().delete(list.get(0).getId());
            System.out.println(delete.getMsg());
        }
    }

}
