package com.serookie.springcloud.service.Impl;

import com.serookie.springcloud.entity.Payment;
import com.serookie.springcloud.mapper.PaymentMapper;
import com.serookie.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public boolean insertPayment(Payment payment) {
        return paymentMapper.insertPayment(payment)>0;
    }

    @Override
    public Payment getPayment(Integer id) {
        return paymentMapper.getPayment(id);
    }
}
