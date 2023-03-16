package com.pc.ddd.api.enums;

/**
 *
 * @author pengchao
 * @since 2023/3/16 16:31
 */
public enum OrderStatus {
    INIT("生成"),
    PAY("已支付"),
    SHIP("发货"),
    ARRIVE("到达"),
    SIGN("签收"),
    FINISH("结束");

    private String desc;

    OrderStatus(String desc) {
        this.desc = desc;
    }
}
