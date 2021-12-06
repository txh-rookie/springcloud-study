package com.serookie.springcloud.service;

import com.serookie.springcloud.entity.Payment;
import com.serookie.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @GetMapping("/payment/{id}")
    public Result getPayment(@PathVariable("id") Integer id);
    @GetMapping("/payment/timeout")
    public String OpenFeignTimeOut();
}
