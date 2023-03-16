package com.pc.ddd.adapter.restful;

import com.pc.ddd.api.dto.cmd.ModifyOrderItemCmd;
import com.pc.ddd.api.dto.qry.PageQry;
import com.pc.ddd.api.dto.response.*;
import com.pc.ddd.application.service.OrderApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author pengchao
 * @since 2023/3/15 20:31
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderApplicationService orderService;

    @GetMapping("/page")
    public PageResponse<OrderDTO> pageList(@RequestParam String id) {
        PageQry pageQry = new PageQry();
        PageDTO<OrderDTO> pageResult = orderService.pageList(pageQry);
        return PageResponse.of(
                pageResult.getItems(),
                pageResult.getItemsTotal(),
                pageResult.getPageSize(),
                pageResult.getPageNumber());
    }


    @GetMapping("/save")
    public Response get(@RequestBody ModifyOrderItemCmd cmd) {
        orderService.modifyItemQuantity(cmd);
        return null;
    }

}
