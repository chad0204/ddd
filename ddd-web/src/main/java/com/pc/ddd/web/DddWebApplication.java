package com.pc.ddd.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.pc.ddd"
//        "com.pc.ddd.domain",
//        "com.pc.ddd.web",
//        "com.pc.ddd.application",
})
//@MapperScan("com.pc.ddd.infrastructure.mapper")
public class DddWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddWebApplication.class, args);
    }

}
