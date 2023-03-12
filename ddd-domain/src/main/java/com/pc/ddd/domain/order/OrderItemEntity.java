package com.pc.ddd.domain.order;

import com.pc.ddd.domain.product.Product;
import lombok.Data;

@Data
public class OrderItemEntity {
    //id
    private Long id;
    //商品(值对象)
    private Product product;
    //数量(值对象)
    private Integer quantity;
    // item总价(值对象)
    private Float itemAmt;

    public void modifyQuantity(Integer quantity) {
        this.quantity = quantity;
        this.itemAmt = this.product.getPrice() * quantity;
    }
}
