package com.pc.ddd.domain.model.order;

import com.pc.ddd.api.dto.cmd.ModifyOrderItemCmd;
import com.pc.ddd.api.dto.cmd.OrderAddCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 领域服务 跨多个实体
 *
 * 比如计算订单的商品总价
 * 聚合实体数量非常多, 无法在聚合中完成, 直接在聚合中完成浪费内存。但是单个聚合实体又无法完成。
 * 要么在聚合中依赖repository（尽量避免在聚合中使用repo）
 *
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
         * A B并发查到3
         * 并执行计算
         *  A +2 = 5
         *  B -1 = 2
         * A结束后是5, 然后B结束是2, 最终结果可能是5也可能是2, 但是期望是4
         *
         *
         */
        //因为是先查后更新, 更新不是原子操作, 所以
        //如果有其他线程获取聚合根, 并发操作 线程A +2 线程B -1
        //要么乐观锁 要么悲观锁
        //需要加版本号
        //所以聚合要小
        //如果并发失败, 就是无效操作, 会不会是性能浪费
        //
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
