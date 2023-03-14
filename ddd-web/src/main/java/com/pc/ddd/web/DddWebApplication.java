package com.pc.ddd.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.pc.ddd"
//        "com.pc.ddd.domain",
//        "com.pc.ddd.web",
//        "com.pc.ddd.application",
})
public class DddWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddWebApplication.class, args);
    }

}
