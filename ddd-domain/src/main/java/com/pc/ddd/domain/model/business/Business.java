package com.pc.ddd.domain.model.business;

import com.pc.ddd.domain.model.stage.StageGroup;
import lombok.*;

import java.util.Date;

/**
 *
 * @author pengchao
 * @since 2023/3/20 17:47
 */
@Data
public class Business {

    private Long Id;

    private String businessStatus;

    private String endStatus;

    private String endReason;

    private Date endTime;

    private StageGroup stageGroup;


    //聚合内部一致性控制, 代码内聚

    //问题： 注意并发, 需要加锁

    //变更阶段流程

    //更新商机 变更状态

    //无效商机无法更新


}
