package com.pc.ddd.adapter.restful;

import com.pc.ddd.api.dto.cmd.OrderCmd;
import com.pc.ddd.api.dto.qry.OrderQry;
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
        OrderQry orderQry = new OrderQry();
        PageDTO<OrderDTO> pageResult = orderService.pageList(orderQry);
        return PageResponse.of(
                pageResult.getItems(),
                pageResult.getItemsTotal(),
                pageResult.getPageSize(),
                pageResult.getPageNumber());
    }


    @GetMapping("/save")
    public Response get(@RequestBody OrderCmd cmd) {

        return null;
    }

}
