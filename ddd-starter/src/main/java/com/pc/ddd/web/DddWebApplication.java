package com.pc.ddd.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.pc.ddd"//这样配置扫描的有点多, 不如指定具体目录
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
