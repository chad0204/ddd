package com.pc.ddd.domain.common;

import java.util.List;
/**
 *
 * 仓储接口
 *
 */
public interface Repo<BO, DO> {

    abstract BO toBO(DO record);

    abstract DO toDO(BO bo);

    abstract List<BO> toBOList(List<DO> records);
}
