package com.serookie.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.serookie.springcloud.entity.Result;
import com.serookie.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/{id}")
    public Result getPayment(@PathVariable("id") Integer id){
        Result payment = paymentService.getPayment(id);
        return payment;
    }
    @GetMapping("/consumer/timeout")
    public String timeout(){
        return paymentService.OpenFeignTimeOut();
    }
}
