package com.jackpan.orange.client;

import com.jackpan.orange.converter.HttpResponseConverters;
import com.jackpan.orange.request.HttpDeleteRequest;
import com.jackpan.orange.request.Request;
import com.jackpan.orange.response.AcknowledgedResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Orange rest 客户端。
 *
 * @author jackpan
 */
public class OrangeRestClient implements Closeable {

    private static final Logger logger = LogManager.getLogger(OrangeRestClient.class);

    private String serverHost;

    private String contentType = "application/x-www-form-urlencoded; charset=UTF-8";

    private final JwtAuthClient jwtAuthClient = new JwtAuthClient(this);
    private final HeadersClient headersClient = new HeadersClient(this);
    private final MonitorClient monitorClient = new MonitorClient(this);
    private final RedirectClient redirectClient = new RedirectClient(this);
    private final RewriteClient rewriteClient = new RewriteClient(this);
    private final KeyAuthClient keyAuthClient = new KeyAuthClient(this);
    private final BasicAuthClient basicAuthClient = new BasicAuthClient(this);
    private final HmacAuthClient hmacAuthClient = new HmacAuthClient(this);
    private final SignatureAuthClient signatureAuthClient = new SignatureAuthClient(this);
    private final RateLimitingClient rateLimitingClient = new RateLimitingClient(this);
    private final PropertyRateLimitingClient propertyRateLimitingClient = new PropertyRateLimitingClient(this);

    public OrangeRestClient(OrangeRestClientConfig restClientConfig) {
        this.serverHost = restClientConfig.getServerHost();
    }


    /**
     * 提供 Jwt Auth模块的客户端
     *
     * @return 客户端对象
     */
    public JwtAuthClient jwtAuth() {
        return jwtAuthClient;
    }

    /**
     * 提供 Headers 模块的客户端
     *
     * @return 客户端对象
     */
    public HeadersClient headers() {
        return headersClient;
    }

    /**
     * 提供 Monitor 模块的客户端
     *
     * @return 客户端对象
     */
    public MonitorClient monitor() {
        return monitorClient;
    }

    /**
     * 提供 Redirect 模块的客户端
     *
     * @return 客户端对象
     */
    public RedirectClient redirect() {
        return redirectClient;
    }

    /**
     * 提供 Rewrite 模块的客户端
     *
     * @return 客户端对象
     */
    public RewriteClient rewrite() {
        return rewriteClient;
    }


    /**
     * 提供 key auth 模块的客户端
     *
     * @return 客户端对象
     */
    public KeyAuthClient keyAuth() {
        return keyAuthClient;
    }

    /**
     * 提供 basic auth 模块的客户端
     *
     * @return 客户端对象
     */
    public BasicAuthClient basicAuth() {
        return basicAuthClient;
    }

    /**
     * 提供 hmac auth 模块的客户端
     *
     * @return 客户端对象
     */
    public HmacAuthClient hmacAuth() {
        return hmacAuthClient;
    }

    /**
     * 提供 Signature auth 模块的客户端
     *
     * @return 客户端对象
     */
    public SignatureAuthClient signatureAuth() {
        return signatureAuthClient;
    }

    /**
     * 提供 Rate Limiting 模块的客户端
     *
     * @return 客户端对象
     */
    public RateLimitingClient rateLimiting() {
        return rateLimitingClient;
    }

    /**
     * 提供 Property Rate Limiting 模块的客户端
     *
     * @return 客户端对象
     */
    public PropertyRateLimitingClient propertyRateLimiting() {
        return propertyRateLimitingClient;
    }

    @Override
    public void close() {

    }

    /**
     * 内部执行请求的方法
     * Execute internal request in orange rest client
     *
     * @param request 请求参数
     * @return AcknowledgedResponse
     */
    public AcknowledgedResponse performRequest(Request request) {
        String serverUrl = serverHost + request.getEndpoint();
        AcknowledgedResponse response = null;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            logger.info("Request server {}", serverUrl);
            HttpUriRequest httpUriRequest = convertRequest(request, serverUrl);
            response = HttpResponseConverters.httpResponse(httpclient.execute(httpUriRequest));

        } catch (IOException e) {
            logger.error("OrangeRestClient performRequest error: ", e);
            throw new RuntimeException("OrangeRestClient performRequest error:", e);
        }

        return response;
    }

    /**
     * Request 转换 HttpUriRequest
     * Request convert to HttpUriRequest
     *
     * @param request   请求参数
     * @param serverUrl Orange API URL
     * @return HttpUriRequest
     */
    private HttpUriRequest convertRequest(Request request, String serverUrl) throws UnsupportedEncodingException {

        HttpUriRequest httpUriRequest = null;
        if ("GET".equals(request.getMethod())) {
            HttpGet httpGet = new HttpGet(serverUrl);
            httpGet.setHeader("Content-Type", contentType);
            httpUriRequest = httpGet;
        } else if ("POST".equals(request.getMethod())) {
            HttpPost httpPost = new HttpPost(serverUrl);
            httpPost.setHeader("Content-Type", contentType);
            List<NameValuePair> formData = new ArrayList<>();
            request.getParameters().forEach((name, value) -> {
                formData.add(new BasicNameValuePair(name, value));
            });
            UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(formData);
            httpPost.setEntity(encodedFormEntity);
            httpUriRequest = httpPost;
        } else if ("PUT".equals(request.getMethod())) {
            HttpPut httpPut = new HttpPut(serverUrl);
            httpPut.setHeader("Content-Type", contentType);
            List<NameValuePair> formData = new ArrayList<>();
            request.getParameters().forEach((name, value) -> {
                formData.add(new BasicNameValuePair(name, value));
            });
            UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(formData);
            httpPut.setEntity(encodedFormEntity);
            httpUriRequest = httpPut;
        } else if ("DELETE".equals(request.getMethod())) {
            HttpDeleteRequest httpDelete = new HttpDeleteRequest(serverUrl);
            httpDelete.setHeader("Content-Type", contentType);
            List<NameValuePair> formData = new ArrayList<>();
            request.getParameters().forEach((name, value) -> {
                formData.add(new BasicNameValuePair(name, value));
            });
            UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(formData);
            httpDelete.setEntity(encodedFormEntity);
            httpUriRequest = httpDelete;
        } else {
            throw new UnsupportedOperationException("Only support " + request.getMethod() + " Request");
        }

        return httpUriRequest;

    }
}
