package com.pc.ddd.application.service;


import com.pc.ddd.application.dto.CrmPoolDto;
import com.pc.ddd.domain.pool.CrmPool;
import com.pc.ddd.domain.pool.CrmPoolMemberDomainService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pengchao
 * @since 2023/3/14 18:32
 */
@Service
public class CrmPoolMemberService {

    @Autowired
    private CrmPoolMemberDomainService crmPoolDomainService;
    
    public CrmPoolDto get(String id) {
        CrmPool crmPool = crmPoolDomainService.get(id);
        CrmPoolDto crmPoolDto = new CrmPoolDto();
        BeanUtils.copyProperties(crmPool, crmPoolDto);
        return crmPoolDto;
    }

}
