package com.pc.ddd.domain.order;

import com.pc.ddd.domain.order.vo.Product;

/**
 *
 * @author pengchao
 * @since 2023/3/13 15:18
 */
public interface OrderAggregateRepository {

    OrderAggregate find(Product product);

    void put(OrderAggregate orderAggregate);
}
