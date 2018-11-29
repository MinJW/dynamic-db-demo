package com.mjw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mjw.business.*.dao")
public class DynamicDbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDbDemoApplication.class, args);
    }
}
