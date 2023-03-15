package com.pc.ddd;


import com.pc.ddd.web.DddWebApplication;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {DddWebApplication.class})})
@SpringBootApplication(scanBasePackages = {"com.pc.ddd"})
class DddWebApplicationTests {

    public static void main(String[] args) {
        //这里填的是TestApplication
        ApplicationContext context = SpringApplication.run(DddWebApplication.class, args);
    }

}
