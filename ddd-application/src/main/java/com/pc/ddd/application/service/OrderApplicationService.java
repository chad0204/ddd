package com.pc.ddd.application.service;

import com.pc.ddd.api.dto.cmd.ModifyOrderItemCmd;
import com.pc.ddd.api.dto.cmd.OrderAddCmd;
import com.pc.ddd.api.dto.qry.PageQry;
import com.pc.ddd.api.dto.response.OrderDTO;
import com.pc.ddd.api.dto.response.PageDTO;
import com.pc.ddd.api.dto.response.Response;
import com.pc.ddd.application.execute.cmd.OrderAddCmdExe;
import com.pc.ddd.application.execute.cmd.OrderModifyItemQuantityCmdExe;
import com.pc.ddd.application.execute.cmd.OrderModifyItemStatusCmdExe;
import com.pc.ddd.application.execute.query.OrderPageQryExe;
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



    private final OrderPageQryExe orderPageQryExe;
    private final OrderAddCmdExe orderAddCmdExe;
    private final OrderModifyItemQuantityCmdExe modifyItemQuantityCmdExe;
    private final OrderModifyItemStatusCmdExe modifyItemStatusCmdExe;

    @Autowired
    public OrderApplicationService(OrderPageQryExe orderPageQryExe, OrderAddCmdExe orderAddCmdExe, OrderModifyItemQuantityCmdExe modifyItemQuantityCmdExe, OrderModifyItemStatusCmdExe modifyItemStatusCmdExe) {
        this.orderPageQryExe = orderPageQryExe;
        this.orderAddCmdExe = orderAddCmdExe;
        this.modifyItemQuantityCmdExe = modifyItemQuantityCmdExe;
        this.modifyItemStatusCmdExe = modifyItemStatusCmdExe;
    }


    /**
     * 因为没有写操作, 就算破坏聚合封装性也没关系
     * @param qry
     * @return
     */
    public PageDTO<OrderDTO> pageList(PageQry qry) {
        return orderPageQryExe.execute(qry);
    }

    public Response save(OrderAddCmd cmd) {
        orderAddCmdExe.execute(cmd);
        return Response.buildSuccess();
    }

    public Boolean modifyItemQuantity(ModifyOrderItemCmd cmd) {
        return modifyItemQuantityCmdExe.execute(cmd);
    }

    public Boolean modifyItemStatus(ModifyOrderItemCmd cmd) {
        return modifyItemStatusCmdExe.execute(cmd);
    }
}
