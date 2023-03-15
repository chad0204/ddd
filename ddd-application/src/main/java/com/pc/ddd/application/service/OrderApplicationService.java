package com.pc.ddd.application.service;

import com.pc.ddd.api.dto.cmd.OrderCmd;
import com.pc.ddd.api.dto.qry.OrderQry;
import com.pc.ddd.api.dto.response.OrderDTO;
import com.pc.ddd.api.dto.response.PageDTO;
import com.pc.ddd.domain.order.OrderAggregate;
import com.pc.ddd.domain.order.OrderAggregateRepository;
import com.pc.ddd.domain.order.OrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author pengchao
 * @since 2023/3/15 19:38
 */
@Service
public class OrderApplicationService {

    @Autowired
    private OrderAggregateRepository orderAggregateRepository;
    @Autowired
    private OrderDomainService domainService;

    public PageDTO<OrderDTO> pageList(OrderQry qry) {

        //TODO Repository是围绕聚合实现的, 这里返回的都是聚合根, 而query应该不需要依赖领域对象,
        // 但是由于这里不能直接调用mapper, 所以还是通过domain层来实现, 但是只用到repository接口。

        //qry -> condition
        OrderAggregateRepository.MappingFindCondition condition = OrderAggregateRepository.MappingFindCondition.builder().build();
        //domain -> dto
        orderAggregateRepository.pagingByCondition(condition);
        return null;
    }


    public PageDTO<OrderDTO> save(OrderCmd cmd) {
        //cmd -> condition
        //domainService
        return null;
    }



}
