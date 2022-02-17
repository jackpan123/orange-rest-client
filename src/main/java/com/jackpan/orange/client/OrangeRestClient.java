package com.jackpan.orange.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Closeable;
import java.io.IOException;

public class OrangeRestClient implements Closeable {

    private static final Logger logger = LogManager.getLogger(OrangeRestClient.class);


    private final JwtAuthClient jwtAuthClient = new JwtAuthClient(this);
    public OrangeRestClient(OrangeRestClientBuilder restClientBuilder) {

    }


    @Override
    public void close() throws IOException {

    }
}
