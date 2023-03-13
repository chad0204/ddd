package com.pc.ddd.domain.order;

import com.pc.ddd.domain.order.vo.Product;

/**
 * TODO
 *
 * @author pengchao
 * @since 2023/3/13 17:29
 */
public class OrderDomainService {

    private OrderAggregateRepository orderAggregateRepository;
    private OrderAggregateFactory orderAggregateFactory;


    public void biz() {
        OrderAggregate originalOrderAggregate = orderAggregateFactory.createOrderAggregate();
        orderAggregateRepository.put(originalOrderAggregate);

        //如果有其他线程获取聚合根, 并发操作
        OrderAggregate orderAggregate = orderAggregateRepository.find(new Product());
        orderAggregate.modifyItemQuantity(new Product(), 10);
        orderAggregateRepository.put(orderAggregate);

    }


}
