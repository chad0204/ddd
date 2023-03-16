package com.pc.ddd.application.service;

import com.pc.ddd.api.dto.cmd.ModifyOrderItemCmd;
import com.pc.ddd.api.dto.qry.PageQry;
import com.pc.ddd.api.dto.response.OrderDTO;
import com.pc.ddd.api.dto.response.PageDTO;
import com.pc.ddd.application.convert.IOrderConvert;
import com.pc.ddd.domain.model.order.OrderAggregate;
import com.pc.ddd.domain.model.order.OrderAggregateRepository;
import com.pc.ddd.domain.model.order.OrderDomainService;
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
    private OrderDomainService orderDomainService;

    /**
     * 是不是可以不走domain层, 因为没有写操作, 就算破坏聚合封装性也没关系
     * @param qry
     * @return
     */
    public PageDTO<OrderDTO> pageList(PageQry qry) {

        //TODO Repository是围绕聚合实现的, 这里返回的都是聚合根, 而query应该不需要依赖领域对象,
        // 但是由于这里不能直接调用mapper, 所以还是通过domain层来实现, 但是只用到repository接口。

        PageDTO<OrderAggregate> page = orderAggregateRepository.page(qry);
        //domain -> dto
        IOrderConvert.INSTANCE.toDTOList(page.getItems());
        return null;
    }

    public Boolean save(ModifyOrderItemCmd cmd) {
        return orderDomainService.create(cmd);
    }

    public Boolean modifyItemQuantity(ModifyOrderItemCmd cmd) {
        return orderDomainService.modifyItemQuantity(cmd);
    }

    public Boolean modifyItemStatus(ModifyOrderItemCmd cmd) {
        return orderDomainService.modifyItemStatus(cmd);
    }
}
