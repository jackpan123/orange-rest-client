package com.jackpan.orange.client;

import com.jackpan.orange.response.AcknowledgedResponse;
import org.junit.Test;

public class OrangeRestClientTest {


    @Test
    public void jwtAuthPluginTest() {
        OrangeRestClientConfig config = new OrangeRestClientConfig();
        config.setServerHost("http://192.168.102.33:7777");
        OrangeRestClient orangeRestClient = new OrangeRestClient(config);
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
}
