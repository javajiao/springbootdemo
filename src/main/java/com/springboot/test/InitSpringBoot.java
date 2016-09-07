package com.springboot.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Jerry on 16/8/1.
 */
@SpringBootApplication
@MapperScan(basePackages = "com.springboot.test.dao")
@EnableEurekaClient
public class InitSpringBoot extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(InitSpringBoot.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(InitSpringBoot.class, args);
    }


}
