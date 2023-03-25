package com.pc.ddd.infrastructure.reposiroty;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pc.ddd.api.enums.OrderStatus;
import com.pc.ddd.domain.common.Repo;
import com.pc.ddd.domain.model.order.OrderAggregate;
import com.pc.ddd.domain.model.order.OrderAggregateRepository;
import com.pc.ddd.domain.model.order.OrderItem;
import com.pc.ddd.infrastructure.convert.IOrderConvert;
import com.pc.ddd.infrastructure.mapper.OrderItemMapper;
import com.pc.ddd.infrastructure.mapper.OrderMapper;
import com.pc.ddd.infrastructure.po.OrderDO;
import com.pc.ddd.infrastructure.po.OrderItemDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * ServiceImpl的使用是Repo接口继承IService<PO>, Repo实现继承ServiceImpl<Mapper, PO>
 * 由于Repo接口的定义在domain层, domain层拿不到PO, 无法让接口继承IService<PO>。
 * 所以这里只有Repo实现继承ServiceImpl<Mapper, PO>, 仅仅在Repo内部简化代码。
 *
 * @author pengchao
 * @since 2023/3/13 18:19
 */
@Component
public class OrderAggregateRepositoryImpl extends ServiceImpl<OrderMapper, OrderDO>
        implements OrderAggregateRepository, Repo<OrderAggregate, OrderDO> {

    //内部聚合, 这里repo使用了ServiceImpl继承OrderMapper的crud, 然后通过组合使用OrderItemMapper
    //大部分聚合(只有聚合根)可能不需要组合, 只继承ServiceImpl即可
    private final OrderItemMapper orderItemMapper;

    @Autowired
    public OrderAggregateRepositoryImpl(OrderItemMapper orderItemMapper) {

        this.orderItemMapper = orderItemMapper;
    }

    @Override
    public OrderAggregate toBO(OrderDO record) {
        //TODO join

//        orderItemMapper.selectList(Wrappers.lambdaQuery().in("id", Lists.newArrayList("")));

        return IOrderConvert.INSTANCE.toBO(record);
    }

    @Override
    public OrderDO toDO(OrderAggregate orderAggregate) {
        return IOrderConvert.INSTANCE.toDO(orderAggregate);
    }

    @Override
    public List<OrderAggregate> toBOList(List<OrderDO> records) {

//        join orderItem

        List<OrderAggregate> orderAggregates = IOrderConvert.INSTANCE.toBOList(records);

        return null;
    }


    @Override
    public List<OrderItem> list(Long id) {
        return null;
    }

    @Override
    public Boolean save(OrderAggregate orderAggregate) {
        return this.save(toDO(orderAggregate));
    }

    @Override
    @Transactional
    public Boolean update(OrderAggregate orderAggregate) {
        //修改某个item
        OrderItem orderItemEntity = orderAggregate.getItems().get(0);
        OrderItemDO orderItemDO = IOrderConvert.INSTANCE.toDOForItem(orderItemEntity);
        int update = orderItemMapper.update(orderItemDO,
                Wrappers.<OrderItemDO>lambdaUpdate()
                        //如果为空, 清零
                        .set(orderItemDO.getItemAmt() == null, OrderItemDO::getItemAmt, 0)
                        .set(OrderItemDO::getVersion, orderItemDO.getVersion() + 1) //版本号+1
                        .eq(OrderItemDO::getVersion, orderItemDO.getVersion())// 控制并发
                        .eq(OrderItemDO::getId, orderItemDO.getId()));

        OrderDO orderDO = toDO(orderAggregate);
        this.lambdaUpdate().eq(OrderDO::getId, orderDO.getId()).update(orderDO);

        if (orderAggregate.getStatus().equals(OrderStatus.FINISH.name())) {
//            TODO sendMsgToPayDomain
        }
        return Boolean.TRUE;
    }

    @Override
    public OrderAggregate get(Long id) {
        return toBO(this.getById(id));
    }
}
