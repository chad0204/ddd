package com.pc.ddd.domain.model.order;

import com.pc.ddd.api.dto.cmd.ModifyOrderItemCmd;
import com.pc.ddd.api.dto.cmd.OrderAddCmd;
import org.springframework.stereotype.Component;

@Component
public class OrderAggregateFactory {

    public OrderAggregate createOrderAggregate(OrderAddCmd cmd) {
        return new OrderAggregate();
    }

}
