package com.pc.ddd.domain.pool;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pengchao
 * @since 2023/3/14 18:32
 */
@Service
public class CrmPoolMemberDomainService {

    @Autowired
    private CrmPoolMemberRepository crmPoolMemberRepository;

    public CrmPool get(String id) {
        return crmPoolMemberRepository.get(id);
    }

}
