package com.pc.ddd.application.convert;


import com.pc.ddd.api.dto.response.OrderDTO;
import com.pc.ddd.domain.model.order.OrderAggregate;
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

    OrderDTO toDTO(OrderAggregate dto);

    OrderAggregate toBO(OrderDTO dto);

    List<OrderDTO> toDTOList(List<OrderAggregate> records);
}
