/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */

package com.pc.ddd.common.util;

/**
 * The Tpt executor
 *
 * @author xiaomian<xiaomian dfire.com>
 * @date 2016 -11-10
 */
public interface IExecutor<REQ, RSP> {

    /**
     * 具体执行内容
     *
     * @param request the request
     * @return rsp rsp
     */
     RSP execute(REQ request) ;



    /**
     * 该执行器是否有效
     *
     * @return
     */
    boolean isDisabled();
}
