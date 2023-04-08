/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */

package com.pc.ddd.common.util.bean;

public interface BeanNameStrategy {
    /**
     * 根据Clazz 获取策略名
     *
     * @param clazz
     * @return
     */
    String getName(Class clazz);

    /**
     * 根据name 获取策略名
     *
     * @param name
     * @return
     */
    String getName(String name);

}
