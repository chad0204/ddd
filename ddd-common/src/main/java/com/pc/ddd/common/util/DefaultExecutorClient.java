/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.pc.ddd.common.util;


import com.pc.ddd.common.util.bean.BeanHelper;
import com.pc.ddd.common.util.bean.BeanNameStrategy;
import com.pc.ddd.common.util.bean.ExecutorBeanNameStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 *
 */
@Component
public class DefaultExecutorClient implements IExecutorClient {
    /**
     * Spring bean容器
     */
    @Resource
    private BeanHelper beanHelper;
    /**
     * 默认BeanName策略
     */
    private BeanNameStrategy beanNameStrategy = new ExecutorBeanNameStrategy();


    @Override
    public <REQ, RSP> RSP execute(REQ request) {
        return execute(request, beanNameStrategy);
    }

    @Override
    public <REQ, RSP> RSP execute(REQ request, BeanNameStrategy beanNameStrategy) {
        String beanName = beanNameStrategy.getName(request.getClass());
        return execute(request, beanName);
    }

    @Override
    public <REQ, RSP> RSP execute(REQ request, String beanName) {
        IExecutor executor = beanHelper.getBean(beanName, IExecutor.class);
        if (executor.isDisabled()) {
            throw new UnsupportedOperationException("该方法已禁用:" + request);
        }
        return (RSP) executor.execute(request);
    }

}
