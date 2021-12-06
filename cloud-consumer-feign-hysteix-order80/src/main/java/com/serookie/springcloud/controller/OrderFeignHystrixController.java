package com.serookie.springcloud.controller;

import com.serookie.springcloud.service.OrderFeignHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignHystrixController {

    @Resource
    private OrderFeignHystrixService service;

    @GetMapping("/consumer/{id}")
    public String consumer(@PathVariable("id") Integer id){
        String infoOk = service.paymentInfo_ok(id);
        return infoOk;
    }
    @GetMapping("/consumer/timeout/{id}")
    public String consumerInfo(@PathVariable("id") Integer id){
        String infoOk = service.paymentInfo_Time(id);
        return infoOk;
    }
}
