package com.pc.ddd.domain.model.order;


import com.pc.ddd.api.dto.qry.PageQry;
import com.pc.ddd.api.dto.response.PageDTO;


/**
 *
 * @author pengchao
 * @since 2023/3/13 15:18
 */
public interface OrderAggregateRepository {

    PageDTO<OrderAggregate> page(PageQry pageQry);

    Boolean save(OrderAggregate orderAggregate);

    Boolean update(OrderAggregate orderAggregate);

    OrderAggregate get(Long id);

}
