package com.jackpan.orange.client;

public class JwtAuthClient {

    private OrangeRestClient orangeRestClient;

    JwtAuthClient(OrangeRestClient orangeRestClient) {
        this.orangeRestClient = orangeRestClient;
    }
}
