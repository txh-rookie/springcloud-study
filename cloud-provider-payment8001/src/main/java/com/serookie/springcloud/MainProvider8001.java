package com.serookie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//声明eureka的客户端
@EnableEurekaClient
public class MainProvider8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainProvider8001.class,args);
    }
}
