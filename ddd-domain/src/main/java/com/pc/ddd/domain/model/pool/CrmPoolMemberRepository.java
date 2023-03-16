package com.pc.ddd.domain.model.pool;

/**
 *
 * 仓储接口
 * @author pengchao
 * @since 2023/3/14 18:23
 */
public interface CrmPoolMemberRepository {

    CrmPool get(String id);

    void add(CrmPool crmPool);
}
