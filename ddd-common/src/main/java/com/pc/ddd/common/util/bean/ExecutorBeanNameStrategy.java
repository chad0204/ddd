/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.pc.ddd.common.util.bean;

import org.springframework.util.StringUtils;


public class ExecutorBeanNameStrategy implements BeanNameStrategy {

    /**
     * executor后缀
     */
    private static final String EXECUTOR = "Executor";
    /**
     * request后缀
     */
    private static final String REQUEST = "Request";

    @Override
    public String getName(Class clazz) {
        String clazzName = StringUtils.replace(clazz.getSimpleName(), REQUEST, EXECUTOR);
        return StringUtils.uncapitalize(clazzName);
    }

    @Override
    public String getName(String name) {
        String clazzName = StringUtils.replace(name, REQUEST, EXECUTOR);
        return StringUtils.uncapitalize(clazzName);
    }
}
