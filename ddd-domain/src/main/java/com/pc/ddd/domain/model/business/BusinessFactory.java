package com.pc.ddd.domain.model.business;

import com.pc.ddd.domain.common.BOFactory;
import com.pc.ddd.domain.common.BusinessContext;
import org.springframework.stereotype.Component;

/**
 * @author pengchao
 * @since 2023/3/20 17:52
 */
@Component
public class BusinessFactory implements BOFactory<Business> {
    @Override
    public Business create(BusinessContext businessContext) {
        //初始化商机
        //初始化阶段流程
        return null;
    }
}
