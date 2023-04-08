/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */

package com.pc.ddd.common.util;


import com.pc.ddd.common.util.bean.BeanNameStrategy;

public interface IExecutorFactory {
    /**
     * 执行器
     *
     * @param request          请求参数
     * @param beanNameStrategy 获取执行bean的策略
     * @param <REQ>
     * @param <RSP>
     * @return
     */
    <REQ, RSP> RSP execute(REQ request, BeanNameStrategy beanNameStrategy);

    /**
     * 执行器
     *
     * @param request 请求参数, 默认执行器
     * @param <REQ>
     * @param <RSP>
     * @return
     */
    <REQ, RSP> RSP execute(REQ request);

    /**
     * 执行
     *
     * @param request  请求参数
     * @param beanName 执行器的beanName
     * @param <REQ>
     * @param <RSP>
     * @return
     */
    <REQ, RSP> RSP execute(REQ request, String beanName);

}
