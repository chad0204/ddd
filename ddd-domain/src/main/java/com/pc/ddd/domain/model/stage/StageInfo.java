package com.pc.ddd.domain.model.stage;

import lombok.Data;

/**
 * 阶段
 *
 * @author pengchao
 * @since 2023/3/20 17:50
 */
@Data
public class StageInfo {

    private Long id;

    private String stageName;

    private Integer ordinal;

    private String isEndStage;

}
