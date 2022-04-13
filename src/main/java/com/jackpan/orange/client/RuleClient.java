package com.jackpan.orange.client;
import com.jackpan.orange.response.AcknowledgedResponse;

import java.util.List;

public interface RuleClient<E> {

    AcknowledgedResponse create(E rule);

    /**
     * 获取选择器的规则列表
     *
     * @return List<JwtRule>
     */
    List<E> list();


    AcknowledgedResponse update(E rule);


    /**
     * 删除选择器信息
     *
     * @param ruleId 选择器ID
     * @return AcknowledgedResponse
     */
    AcknowledgedResponse delete(String ruleId);

}
