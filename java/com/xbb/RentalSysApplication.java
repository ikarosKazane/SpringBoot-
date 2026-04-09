package com.xbb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xbb.mapper")
@SpringBootApplication
public class RentalSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalSysApplication.class, args);
    }

}
