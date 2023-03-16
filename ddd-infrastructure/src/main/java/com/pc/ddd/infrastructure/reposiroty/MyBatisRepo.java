package com.pc.ddd.infrastructure.reposiroty;

import java.util.List;

public interface MyBatisRepo<ID, BO, DO> {

    abstract BO toBO(DO record);

    abstract DO toDO(BO bo);

    abstract List<BO> toBOList(List<DO> records);

}
