package com.serookie.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PaymentService {

    //正常访问 ok
    public String paymentInfo_ok(Integer id){
        return "线程池： "+Thread.currentThread().getName()+" paymentInfo_ok,id "+id+"\t"+"哈哈";
    }
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
//    })
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            // 开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentInfo_TimeOut(Integer id){
//        int timeNumber=5;
//        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        int i=10/0;
        if(id<0){
            throw new RuntimeException("id,不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
//        return "线程池："+Thread.currentThread().
//                getName()+" paymentInfo_TimeOut,id: "+id+"\t"+"哈哈"+"耗时（秒）";
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号:"+uuid;
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        //return "当前线程名称:"+Thread.currentThread().getName()+" 服务运行错误";
        return "id 不能为负数，请稍后再试, id"+id;
    }

//    //全局定义的服务降级
//    public String payment_Global_FallbackMethod(){
//
//        return "Global异常处理信息，请稍后再试";
//    }
}
