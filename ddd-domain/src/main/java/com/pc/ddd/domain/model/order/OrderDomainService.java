package com.pc.ddd.domain.model.order;

import com.pc.ddd.api.dto.cmd.ModifyOrderItemCmd;
import com.pc.ddd.api.dto.cmd.OrderAddCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 领域服务 跨多个实体
 *
 * @author pengchao
 * @since 2023/3/13 17:29
 */
@Service
public class OrderDomainService {

    @Autowired
    private OrderAggregateRepository orderAggregateRepository;
    @Autowired
    private OrderAggregateFactory orderAggregateFactory;

    public Boolean create(OrderAddCmd cmd) {
        OrderAggregate orderAggregate = orderAggregateFactory.createOrderAggregate(cmd);
        return orderAggregateRepository.save(orderAggregate);
    }

    /**
     * TODO 是不是应该放在应用层
     * @param cmd
     * @return
     */
    public Boolean modifyItemQuantity(ModifyOrderItemCmd cmd) {
        /*
         *
         *  3 + 2 - 1 = 4
         *
         * 执行先A 后 B
         *  A +2 = 5
         *  B -1 = 2
         * A结束后是5, 然后B结束是2
         *
         *
         */
        //因为是先查后更新, 更新不是原子操作, 所以
        //如果有其他线程获取聚合根, 并发操作 线程A +2 线程B -1
        //需要加版本号
        //所以聚合要小
        //如果并发失败, 就是无效操作, 会不会是性能浪费
        OrderAggregate orderAggregate = orderAggregateRepository.get(cmd.getOrderId());
        orderAggregate.modifyItemQuantity(cmd.getItemId(), cmd.getQuantity());
        return orderAggregateRepository.update(orderAggregate);
    }

    public Boolean modifyItemStatus(ModifyOrderItemCmd cmd) {
        OrderAggregate orderAggregate = orderAggregateRepository.get(cmd.getOrderId());
        orderAggregate.modifyItemStatus(cmd.getItemId(), cmd.getStatus());
        return orderAggregateRepository.update(orderAggregate);
    }
}
