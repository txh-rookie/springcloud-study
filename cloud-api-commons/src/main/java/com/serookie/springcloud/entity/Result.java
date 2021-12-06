package com.serookie.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//统一的返回接口
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    //返回编码
    private Integer code;
    //返回的消息
    private String message;
    //返回的对象
    private T data;

    public Result(Integer code,String message){
        this(code,message,null);
    }
}
