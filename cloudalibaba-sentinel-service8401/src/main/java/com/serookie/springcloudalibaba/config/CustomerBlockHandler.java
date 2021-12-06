package com.serookie.springcloudalibaba.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.serookie.springcloud.entity.Result;

//定义全局限流处理类
public class CustomerBlockHandler {

    //定义这个customer的处理方法
    public static Result customerBlcokHandler(BlockException e){
        return new Result(444,"自定义的限流规则");
    }
}
