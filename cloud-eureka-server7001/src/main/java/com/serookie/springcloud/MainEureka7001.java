package com.serookie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//声明服务注册中心
@EnableEurekaServer
public class MainEureka7001 {
    public static void main(String[] args) {
        SpringApplication.run(MainEureka7001.class,args);
    }
}
