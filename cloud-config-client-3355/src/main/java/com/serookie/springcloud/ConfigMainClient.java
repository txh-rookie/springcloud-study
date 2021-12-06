package com.serookie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigMainClient {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMainClient.class,args);
    }
}
