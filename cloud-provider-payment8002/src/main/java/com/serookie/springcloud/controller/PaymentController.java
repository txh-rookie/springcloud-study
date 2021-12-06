package com.serookie.springcloud.controller;

import com.serookie.springcloud.entity.Payment;
import com.serookie.springcloud.entity.Result;
import com.serookie.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment")
    public Result insertPayment(@RequestBody Payment payment){
        boolean flag = paymentService.insertPayment(payment);
        if(flag){
            log.info("数据插入成功,数据为：{},该端口为:{}",payment,serverPort);
            return new Result(200,"数据库插入成功,端口:"+serverPort,payment);
        }else{
            log.error("数据库插入失败:{},该端口为:{}",payment,serverPort);
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
    @GetMapping("/discoveryClient")
    public Result discoveryClient(){
        List<String> services = discoveryClient.getServices();
        Iterator<String> iterator = services.iterator();
        while(iterator.hasNext()){
            log.info("服务发现有:{}",iterator.next());
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance service:instances
             ) {
            log.info("服务发现有:{},{},{},{},{},{},{}",service.getHost(),service.getServiceId(),
                    service.getInstanceId(),service.getMetadata()
                    ,service.getPort(),service.getUri(),service.getScheme());
        }
        return new Result(200,"访问成功",services);
    }
    @GetMapping("/payment/lb")
    public String lb(){
        return serverPort;
    }
}
