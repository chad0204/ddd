package com.pc.ddd.application.execute.cmd;

import com.pc.ddd.api.dto.Result;
import com.pc.ddd.api.dto.cmd.OrderAddCmd;
import com.pc.ddd.domain.model.order.OrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderAddCmdExe extends AbstractCmdExe<OrderAddCmd, Result<Boolean>> {

    private final OrderDomainService orderDomainService;

    @Autowired
    public OrderAddCmdExe(OrderDomainService orderDomainService) {
        this.orderDomainService = orderDomainService;
    }


    @Override
    public Result<Boolean> doExecute(OrderAddCmd cmd) {
        return orderDomainService.create(cmd);
    }


    @Override
    public boolean isDisabled() {
        return false;
    }
}
