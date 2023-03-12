package com.pc.ddd.domain.order;

import com.pc.ddd.domain.product.Product;

import java.util.List;

public class OrderAggregate {
    //聚合唯一标识
    private Long id;
    //订单号(值对象)
    private String orderNo;
    //总价 (值对象)
    private Float amt;
    //订单明细
    private List<OrderItemEntity> items;

    public void modifyItemQuantity(Product product, Integer quantity) {
        //找到商品
        OrderItemEntity item =
                this.items.stream().filter(product::equals).findAny().get();
        //修改数量 返回Item总价
        item.modifyQuantity(quantity);
        Float itemAmt = item.getItemAmt();
        //修改订单总价
        this.amt = this.amt + itemAmt;
    }
}
