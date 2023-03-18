package com.pc.ddd.application.execute.query;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pc.ddd.api.dto.qry.PageQry;
import com.pc.ddd.api.dto.response.OrderDTO;
import com.pc.ddd.api.dto.response.PageDTO;
import com.pc.ddd.infrastructure.mapper.OrderMapper;
import com.pc.ddd.infrastructure.po.OrderDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class OrderPageQryExe {

    @Resource
    private OrderMapper orderMapper;

    public PageDTO<OrderDTO> execute(PageQry qry) {
        //TODO Repository是围绕聚合实现的, 这里返回的都是聚合根, 而query应该不需要依赖领域对象,
        // 但是由于这里不能直接调用mapper, 所以还是通过domain层来实现, 但是只用到repository接口。

        Page<OrderDO> page = new Page<>(qry.getPageNumber(), qry.getPageSize());
        Page<OrderDO> orderDOPage = orderMapper.selectPage(page, Wrappers.lambdaQuery(OrderDO.class));

        //PO -> DTO
        return null;
    }
}
