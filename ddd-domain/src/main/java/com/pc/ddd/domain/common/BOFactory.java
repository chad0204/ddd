package com.pc.ddd.domain.common;

/**
 *
 * @author pengchao
 * @since 2023/3/20 17:53
 */
public interface BOFactory<BO> {
    //搞搞策略模式啥的, 策略房子context中, 初始化工厂时设置

    BO create(BusinessContext businessContext);

}
