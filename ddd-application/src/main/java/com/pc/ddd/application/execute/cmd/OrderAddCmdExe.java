package com.pc.ddd.application.execute.cmd;

import com.pc.ddd.api.dto.cmd.OrderAddCmd;
import com.pc.ddd.domain.model.order.OrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderAddCmdExe {

    @Autowired
    private OrderDomainService orderDomainService;

    public void execute(OrderAddCmd cmd) {
        orderDomainService.create(cmd);
    }
}
