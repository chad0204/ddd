package com.pc.ddd.domain.model.order;

import com.pc.ddd.api.enums.OrderStatus;
import lombok.Data;

import java.util.List;


/**
 * 订单请求（聚合根）
 */
@Data
public class OrderAggregate {
    //聚合唯一标识
    private Long id;
    //订单号(值对象)
    private String orderNo;
    //总价 (值对象) 是根据所有订单项来计算的
    private Double amt;
    //订单明细
    //如果这个对象非常大, 有几万个, 那对内存是一种压力
    private List<OrderItem> items;
    //订单状态 所有订单子项都结束, 更新为结束, 还要发送消息通知支付域结算（支付结算和更新订单状态不是一件事, 通过领域消息解耦）
    private String status;
    //版本号 做并发控制
    private Long version;


    /**
     * 修改订单项中某个商品的数量
     */
    public void modifyItemQuantity(Long itemId, Integer quantity) {
        if (!this.status.equals(OrderStatus.INIT.name())) {
            throw new IllegalArgumentException("只有订单初始化状态可以修改数量");
        }
        OrderItem item = items.stream()
                .filter(orderItem -> orderItem.getId().equals(itemId))
                .findAny().orElse(null);
        if (item == null) {
            //订单不包含此商品
            return;
        }
        //修改数量 返回Item总价
        item.modifyQuantity(quantity);
        //更新订单总价
        this.amt = this.items.stream().mapToDouble(OrderItem::getItemAmt).sum();
    }

    public void modifyItemStatus(Long itemId, String status) {
        OrderItem item = items.stream()
                .filter(orderItem -> orderItem.getId().equals(itemId))
                .findAny().orElse(null);
        if (item == null) {
            //订单不包含此商品
            return;
        }
        item.setStatus(status);

        //如果都结束, 则标记订单状态为结束（基础设施层发消息）
        if (OrderStatus.FINISH.name().equals(status)
                && items.stream().map(OrderItem::getStatus).allMatch(s -> OrderStatus.FINISH.name().equals(s))) {
            this.status = OrderStatus.FINISH.name();
        }
    }
}
