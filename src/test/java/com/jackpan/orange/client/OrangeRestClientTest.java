package com.jackpan.orange.client;

import com.jackpan.orange.entity.Selector;
import com.jackpan.orange.response.AcknowledgedResponse;
import com.jackpan.orange.rule.RuleCondition;
import com.jackpan.orange.rule.RuleFactory;
import com.jackpan.orange.rule.RuleType;
import com.jackpan.orange.rule.SelectorRule;
import org.junit.Before;
import org.junit.Test;

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
    @Test
    public void jwtAuthSelectorTest() {
        List<Selector> list = orangeRestClient.jwtAuth().selectors().list();
        System.out.println();
        SelectorRule selectorRule = RuleFactory.selectorRule()
                .ruleType(RuleType.SINGLE_CONDITION_MATCH)
                .conditions(new RuleCondition()).build();

    }


}
