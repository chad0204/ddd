package com.pc.ddd.web.restful;

import com.pc.ddd.application.dto.CrmPoolDto;
import com.pc.ddd.application.service.CrmPoolMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("health")
public class HeathController {

    @Resource
    private CrmPoolMemberService crmPoolMemberService;

    @GetMapping
    public String health() {
        return "ok: " + System.currentTimeMillis();
    }


    @GetMapping("/get")
    public String get(String id) {
        CrmPoolDto crmPool = crmPoolMemberService.get(id);
        return "ok: " + System.currentTimeMillis();
    }
}
