package com.serookie.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosMain9002.class,args);
    }
}
