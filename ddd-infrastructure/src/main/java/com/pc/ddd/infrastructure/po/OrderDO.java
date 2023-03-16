package com.pc.ddd.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *
 * @author pengchao
 * @since 2023/3/14 18:10
 */
@Data
@TableName("order")
public class OrderDO {
    //聚合唯一标识
    private Long id;
    //订单号(值对象)
    private String orderNo;
    //总价 (值对象) 是根据所有订单项来计算的
    private Float amt;
}
