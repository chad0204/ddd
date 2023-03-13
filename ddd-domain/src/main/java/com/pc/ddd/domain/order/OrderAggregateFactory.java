package com.pc.ddd.domain.order;

public class OrderAggregateFactory {

    public OrderAggregate createOrderAggregate() {
        return new OrderAggregate();
    }

}
