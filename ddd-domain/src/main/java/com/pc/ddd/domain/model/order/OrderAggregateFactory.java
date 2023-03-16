package com.pc.ddd.domain.model.order;

import com.pc.ddd.api.dto.cmd.ModifyOrderItemCmd;
import org.springframework.stereotype.Component;

@Component
public class OrderAggregateFactory {

    public OrderAggregate createOrderAggregate(ModifyOrderItemCmd cmd) {
        return new OrderAggregate();
    }

}
