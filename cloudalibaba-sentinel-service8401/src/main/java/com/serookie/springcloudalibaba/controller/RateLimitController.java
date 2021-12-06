package com.serookie.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.serookie.springcloud.entity.Payment;
import com.serookie.springcloud.entity.Result;
import com.serookie.springcloudalibaba.config.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/resource")
    @SentinelResource(value = "resource",blockHandler = "handleException")
    public Result resource(){
        return new Result(200,"按资源名称限流测试ok",new Payment(2020,"sentinel001"));
    }
    public Result handleException(BlockException e){
        return new Result(444,e.getClass().getCanonicalName()+"\t 服务不可用");
    }
    @GetMapping("/customer")
    @SentinelResource(value = "customer",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "customerBlcokHandler")
    public Result customer(){
        return new Result(200,"按用户资源名称限流测试ok",new Payment(2020,"sentinel001"));
    }

}
