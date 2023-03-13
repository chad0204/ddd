package com.pc.ddd.infrastructure.reposiroty;

import com.pc.ddd.domain.order.OrderAggregate;
import com.pc.ddd.domain.order.OrderAggregateRepository;
import com.pc.ddd.domain.order.vo.Product;

/**
 * TODO
 *
 * @author pengchao
 * @since 2023/3/13 18:19
 */
public class OrderAggregateRepositoryImpl implements OrderAggregateRepository {

    @Override
    public OrderAggregate find(Product product) {
        return null;
    }

    @Override
    public void put(OrderAggregate orderAggregate) {

    }
}
