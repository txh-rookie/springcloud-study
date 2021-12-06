package com.serookie.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerNacosMain83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacosMain83.class,args);
    }
}
