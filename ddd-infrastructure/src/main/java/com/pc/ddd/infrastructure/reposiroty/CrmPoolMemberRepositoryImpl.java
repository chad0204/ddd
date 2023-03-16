package com.pc.ddd.infrastructure.reposiroty;

import com.pc.ddd.domain.model.pool.CrmPool;
import com.pc.ddd.domain.model.pool.CrmPoolMemberRepository;
import com.pc.ddd.infrastructure.po.CrmPoolMember;
import com.pc.ddd.infrastructure.mapper.CrmPoolMemberMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author pengchao
 * @since 2023/3/14 18:27
 */
@Component
public class CrmPoolMemberRepositoryImpl implements CrmPoolMemberRepository {

    private final CrmPoolMemberMapper crmPoolMemberMapper;

    @Autowired
    public CrmPoolMemberRepositoryImpl(CrmPoolMemberMapper crmPoolMemberMapper) {
        this.crmPoolMemberMapper = crmPoolMemberMapper;
    }

    @Override
    public CrmPool get(String id) {
        CrmPoolMember crmPoolMember = crmPoolMemberMapper.selectById(id);
        CrmPool crmPool = new CrmPool();
        BeanUtils.copyProperties(crmPoolMember, crmPool);
        return crmPool;
    }

    @Override
    public void add(CrmPool crmPool) {

    }
}
