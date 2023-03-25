package com.pc.ddd.application.execute.cmd;

import com.pc.ddd.api.dto.cmd.OrderAddCmd;
import com.pc.ddd.domain.model.order.OrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderAddCmdExe extends AbstractCmdExe<OrderAddCmd> {

    @Autowired
    private OrderDomainService orderDomainService;


    @Override
    public Boolean doExecute(OrderAddCmd cmd) {
        return orderDomainService.create(cmd);
    }
}
