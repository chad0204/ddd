package com.pc.ddd.domain.model.order;

import lombok.Data;

/**
 * 订单子项
 */
@Data
public class OrderItem {
    //id
    private Long id;
    //商品(值对象)
    private Product product;
    //数量(值对象)
    private Integer quantity;
    // item总价(值对象)
    private Double itemAmt;
    // 订单状态
    private String status;

    public void modifyQuantity(Integer quantity) {
        this.quantity = quantity;
        this.itemAmt = this.product.getPrice() * quantity;
    }
}
