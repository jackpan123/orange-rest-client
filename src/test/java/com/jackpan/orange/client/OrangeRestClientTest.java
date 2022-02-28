package com.jackpan.orange.client;

import com.jackpan.orange.constant.*;
import com.jackpan.orange.entity.RuleCondition;
import com.jackpan.orange.entity.Selector;
import com.jackpan.orange.entity.SelectorHandle;
import com.jackpan.orange.entity.SelectorRule;
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

    @Test
    public void jwtAuthSelectorCreateTest() {
        // create condition
        RuleCondition.RuleConditionBuilder builder = RuleCondition.RuleConditionBuilder.builder();
        List<RuleCondition> ruleConditions = new ArrayList<>();
        RuleCondition build = builder.conditionType(ConditionType.URI).matchType(MatchType.MATCH).paramValue("").build();
        ruleConditions.add(build);

        // create rule
        SelectorRule selectorRule = RuleFactory.selectorRule()
                .ruleType(RuleType.SINGLE_CONDITION_MATCH)
                .conditions(ruleConditions).build();

        SelectorHandle handle = SelectorHandle.SelectorHandleBuilder.builder()
                .continueOperation(SelectorHandleType.OMIT_SUBSEQUENT_SELECTORS).log(LogType.LOG).build();

        Selector test3 = Selector.SelectorBuilder.builder().name("test3")
                .type(SelectorType.FULL_TRAFFIC).selectorRule(selectorRule).handle(handle).build();

        AcknowledgedResponse response = orangeRestClient.jwtAuth().selectors().create(test3);
        System.out.println(response.getMsg());

    }


}
