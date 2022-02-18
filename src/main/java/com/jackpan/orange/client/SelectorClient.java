package com.jackpan.orange.client;

import java.nio.channels.Selector;
import java.util.List;

/**
 * 选择器客户端
 * @author jackpan
 */
public class SelectorClient {

    private OrangeRestClient orangeRestClient;

    SelectorClient(OrangeRestClient orangeRestClient) {
        this.orangeRestClient = orangeRestClient;
    }

    List<SelectorInfo> list() {
        return null;
    }
}
