package com.pc.ddd.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pc.ddd.domain.model.order.Product;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author pengchao
 * @since 2023/3/14 18:10
 */
@Data
@TableName("order_item")
public class OrderItemDO implements Serializable {

    //id
    @TableId(
            type = IdType.AUTO
    )
    private Long id;
    //商品(值对象)
    private Product product;
    //数量(值对象)
    private Integer quantity;
    // item总价(值对象)
    private Float itemAmt;
    //版本号
    private Long version;

}
