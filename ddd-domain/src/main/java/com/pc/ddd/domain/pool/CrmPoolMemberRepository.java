package com.pc.ddd.domain.pool;

/**
 * @author pengchao
 * @since 2023/3/14 18:23
 */
public interface CrmPoolMemberRepository {

    CrmPool get(String id);

    void add(CrmPool crmPool);
}
