package com.pc.ddd.infrastructure.reposiroty;

import com.pc.ddd.api.dto.response.PageDTO;
import com.pc.ddd.domain.order.OrderAggregate;
import com.pc.ddd.domain.order.OrderAggregateRepository;
import com.pc.ddd.infrastructure.entity.OrderDO;
import com.pc.ddd.infrastructure.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author pengchao
 * @since 2023/3/13 18:19
 */
@Component
public class OrderAggregateRepositoryImpl extends MyBatisRepo<Long, OrderAggregate, OrderDO> implements OrderAggregateRepository {

    @Autowired
    public OrderAggregateRepositoryImpl(OrderMapper mapper) {
        super(mapper);
    }

    @Override
    public Optional<OrderAggregate> fetchOptional(Long id) {
        OrderDO orderDO = mapper.selectById(id);

        //组装OrderItem

        return Optional.empty();
    }

    @Override
    public void add(OrderAggregate orderAggregate) {

    }

    @Override
    public void save(OrderAggregate orderAggregate) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<OrderAggregate> getAll() {
        return null;
    }

    @Override
    OrderAggregate toBO(OrderDO record) {
        return null;
    }

    @Override
    OrderDO toDO(OrderAggregate orderAggregate) {
        return null;
    }

    @Override
    public PageDTO<OrderAggregate> pagingByCondition(MappingFindCondition condition) {
        return null;
    }
}
