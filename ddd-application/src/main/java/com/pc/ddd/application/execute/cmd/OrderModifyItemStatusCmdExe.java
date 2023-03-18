package com.pc.ddd.application.execute.cmd;

import com.pc.ddd.api.dto.cmd.ModifyOrderItemCmd;
import com.pc.ddd.domain.model.order.OrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderModifyItemStatusCmdExe {

    @Autowired
    private OrderDomainService orderDomainService;

    public Boolean execute(ModifyOrderItemCmd cmd) {
        orderDomainService.modifyItemQuantity(cmd);
        return null;
    }
}
