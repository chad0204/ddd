package com.pc.ddd.api.dto.cmd;

import lombok.Data;

/**
 *
 * @author pengchao
 * @since 2023/3/15 20:41
 */
@Data
public class ModifyOrderItemCmd {
    private Long orderId;
    private Long itemId;
    private Integer quantity;
    private String status;
}
