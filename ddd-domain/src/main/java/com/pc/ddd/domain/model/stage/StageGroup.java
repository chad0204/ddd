package com.pc.ddd.domain.model.stage;

import lombok.Data;

import java.util.List;

/**
 * 阶段流程组
 * @author pengchao
 * @since 2023/3/20 17:49
 */
@Data
public class StageGroup {

    private Long id;

    private List<StageInfo> stageInfoList;

}
