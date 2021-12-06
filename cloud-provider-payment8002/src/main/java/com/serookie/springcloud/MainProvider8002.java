package com.serookie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//声明eureka的客户端
@EnableEurekaClient
@EnableDiscoveryClient
public class MainProvider8002 {
    public static void main(String[] args) {
        SpringApplication.run(MainProvider8002.class,args);
    }
}
