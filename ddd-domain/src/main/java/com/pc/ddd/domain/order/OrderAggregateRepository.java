package com.pc.ddd.domain.order;


import com.pc.ddd.api.dto.response.PageDTO;
import com.pc.ddd.domain.common.Repo;
import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author pengchao
 * @since 2023/3/13 15:18
 */
public interface OrderAggregateRepository extends Repo<Long, OrderAggregate> {


    PageDTO<OrderAggregate> pagingByCondition(MappingFindCondition condition);


    @Getter
    @Builder
    class MappingFindCondition {
        private String id;
        private String name;
    }

}
