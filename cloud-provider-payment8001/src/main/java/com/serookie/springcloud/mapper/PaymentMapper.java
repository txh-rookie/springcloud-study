package com.serookie.springcloud.mapper;

import com.serookie.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface PaymentMapper {
    //添加操作
    int insertPayment(Payment payment);
    //查询操作
    Payment getPayment(@Param("id") Integer id);
}
