package com.jackpan.orange.client;

import com.jackpan.orange.converter.HttpResponseConverters;
import com.jackpan.orange.request.Request;
import com.jackpan.orange.response.AcknowledgedResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Orange rest 客户端。
 * @author jackpan
 */
public class OrangeRestClient implements Closeable {

    private static final Logger logger = LogManager.getLogger(OrangeRestClient.class);

    private String serverHost;

    private String contentType = "application/x-www-form-urlencoded; charset=UTF-8";

    private final JwtAuthClient jwtAuthClient = new JwtAuthClient(this);
    public OrangeRestClient(OrangeRestClientConfig restClientConfig) {
        this.serverHost = restClientConfig.getServerHost();
    }


    /**
     * 提供 Jwt Auth模块的客户端
     * @return
     */
    public JwtAuthClient jwtAuth() {
        return jwtAuthClient;
    }

    @Override
    public void close() throws IOException {

    }

    public AcknowledgedResponse performRequest(Request request) {
        String serverUrl = serverHost + request.getEndpoint();
        AcknowledgedResponse response = null;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            logger.info("Request server {}", serverUrl);
            HttpPost httpPost = new HttpPost(serverUrl);
            httpPost.setHeader("Content-Type", contentType);
            List<NameValuePair> formData = new ArrayList<>();
            request.getParameters().forEach((name, value) -> {
                formData.add(new BasicNameValuePair(name, value));
            });
            UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(formData);
            httpPost.setEntity(encodedFormEntity);
            response =  HttpResponseConverters.httpResponse(httpclient.execute(httpPost));

        } catch (IOException e) {

        }

        return response;

    }
}
