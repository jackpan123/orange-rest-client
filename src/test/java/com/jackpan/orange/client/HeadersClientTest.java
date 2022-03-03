package com.jackpan.orange.client;

import com.jackpan.orange.response.AcknowledgedResponse;
import org.junit.Before;
import org.junit.Test;

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

}
