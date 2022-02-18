package com.jackpan.orange.converter;

import com.alibaba.fastjson.JSONObject;
import com.jackpan.orange.response.AcknowledgedResponse;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public final class HttpResponseConverters {

    private static final Logger logger = LogManager.getLogger(HttpResponseConverters.class);

    private HttpResponseConverters() {
    }


    /**
     * Orange返回值转换
     * @param response Orange API接口返回值
     * @return 处理请求值
     */
    public static AcknowledgedResponse httpResponse(HttpResponse response) {
        String result = null;
        try {
            result = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            if (logger.isErrorEnabled()) {
                logger.error("HttpResponseConverters httpResponse error: ", e);
            }
        }

        AcknowledgedResponse acknowledgedResponse = null;
        if (result != null) {
            acknowledgedResponse = JSONObject.parseObject(result, AcknowledgedResponse.class);
        }

        return acknowledgedResponse;
    }
}
