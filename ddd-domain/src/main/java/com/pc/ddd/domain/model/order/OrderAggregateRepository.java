package com.pc.ddd.domain.model.order;


import java.util.List;


/**
 *
 * @author pengchao
 * @since 2023/3/13 15:18
 */
public interface OrderAggregateRepository {

    /**
     * 服务于领域层的查询 必须通过唯一标识来查询
     * @param id
     * @return
     */
    List<OrderItem> list(Long id);

    Boolean save(OrderAggregate orderAggregate);

    Boolean update(OrderAggregate orderAggregate);

    OrderAggregate get(Long id);

}
