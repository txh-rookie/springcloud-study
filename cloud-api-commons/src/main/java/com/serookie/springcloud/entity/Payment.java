package com.serookie.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//支付实体类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Integer id;
    private String serial;
}
