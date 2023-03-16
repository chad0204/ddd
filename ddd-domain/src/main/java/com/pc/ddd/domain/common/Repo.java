package com.pc.ddd.domain.common;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * 仓储接口
 *
 */
public interface Repo<BO, DO> extends IService<DO> {

    abstract BO toBO(DO record);

    abstract DO toDO(BO bo);

    abstract List<BO> toBOList(List<DO> records);
}
