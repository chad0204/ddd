package com.pc.ddd.domain.order;

import com.pc.ddd.domain.order.vo.Product;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author pengchao
 * @since 2023/3/13 17:29
 */
@Service
public class OrderDomainService {

    private OrderAggregateRepository orderAggregateRepository;
    private OrderAggregateFactory orderAggregateFactory;


    public void biz() {
        OrderAggregate originalOrderAggregate = orderAggregateFactory.createOrderAggregate();
        orderAggregateRepository.save(originalOrderAggregate);

        //如果有其他线程获取聚合根, 并发操作
        OrderAggregate orderAggregate = orderAggregateRepository.fetchOptional(1L).orElse(null);
        orderAggregate.modifyItemQuantity(new Product(), 10);
        orderAggregateRepository.save(orderAggregate);



    }


}
