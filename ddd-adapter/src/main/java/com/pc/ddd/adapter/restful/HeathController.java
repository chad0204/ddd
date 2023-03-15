package com.pc.ddd.adapter.restful;

import com.pc.ddd.application.service.CrmPoolMemberService;
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

}
