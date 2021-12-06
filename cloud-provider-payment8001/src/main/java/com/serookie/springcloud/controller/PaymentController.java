package com.serookie.springcloud.controller;

import com.serookie.springcloud.entity.Payment;
import com.serookie.springcloud.entity.Result;
import com.serookie.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment")
    public Result insertPayment(@RequestBody Payment payment){
        boolean flag = paymentService.insertPayment(payment);
        if(flag){
            log.info("数据插入成功,数据为：{},端口:{}",payment,serverPort);
            return new Result(200,"数据库插入成功,端口:"+serverPort,payment);
        }else{
            log.error("数据库插入失败:{},端口:{}",payment,serverPort);
            return new Result(201,"数据库插入失败,端口:"+serverPort,payment);
        }
    }
    @GetMapping("/payment/get/{id}")
    public Result getPayment(@PathVariable("id") Integer id){
        Payment payment = paymentService.getPayment(id);
        log.info("查询的数据为:{},端口:{}",payment,serverPort);
        return payment!=null
                ? new Result(200,"数据查询成功,端口:"+serverPort,payment)
                :new Result(201,"数据查询失败,端口:"+serverPort);
    }
    @GetMapping("/payment/timeout")
    public String OpenFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
    @GetMapping("/payment/lb")
    public String lb(){
        return serverPort;
    }
}
