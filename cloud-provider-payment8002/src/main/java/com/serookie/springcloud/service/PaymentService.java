package com.serookie.springcloud.service;

import com.serookie.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    //添加操作
    boolean insertPayment(Payment payment);
    //查询操作
    Payment getPayment(@Param("id") Integer id);
}
