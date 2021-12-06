package com.serookie.springcloud.controller;

import com.serookie.springcloud.entity.Payment;
import com.serookie.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    // public static final String PAYMENT_URL="http://localhost:8001/";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";
    @Autowired
    private RestTemplate restTemplate;

    //调用8001端口的注册服务
    @PostMapping("/consumer/payment")
    public Result<Payment> order(Payment payment) {
        log.info("添加成功:{}" + payment);
        return restTemplate.postForObject(PAYMENT_URL + "payment", payment, Result.class);
    }

    //调用8001端口的查询服务
    @GetMapping("/consumer/getForObject/{id}")
    public Result<Payment> getPayment(@PathVariable("id") Integer id) {

        return restTemplate.getForObject(PAYMENT_URL + "payment/" + id, Result.class);
    }
    @GetMapping("/consumer/getForEntity/{id}")
    public Result<Payment> getPayment2(@PathVariable("id") Integer id){
        ResponseEntity<Result> entity = restTemplate.getForEntity(PAYMENT_URL+"payment/"+id,Result.class);
        //访问成功
        if(entity.getStatusCode().is2xxSuccessful()){
            log.info("getForEntity访问成功:{}",entity.getBody());
            return entity.getBody();
        }else{
            return new Result<>(400,"操作失败");
        }
    }
}
