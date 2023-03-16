package com.pc.ddd.infrastructure.convert;


import com.pc.ddd.domain.model.order.OrderAggregate;
import com.pc.ddd.domain.model.order.OrderItem;
import com.pc.ddd.infrastructure.po.OrderDO;
import com.pc.ddd.infrastructure.po.OrderItemDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 *
 * @author pengchao
 * @since 2023/3/16 10:52
 */
@Mapper
public interface IOrderConvert {

    IOrderConvert INSTANCE = Mappers.getMapper(IOrderConvert.class);

    OrderAggregate toBO(OrderDO record);

    OrderDO toDO(OrderAggregate bo);

    List<OrderAggregate> toBOList(List<OrderDO> records);


    OrderItem toBOForItem(OrderItemDO record);

    List<OrderItem> toBOListForItem(List<OrderItemDO> records);

    OrderItemDO toDOForItem(OrderItem bo);

}
