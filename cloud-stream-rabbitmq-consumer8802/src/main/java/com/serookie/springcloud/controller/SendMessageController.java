package com.serookie.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Component
@EnableBinding(Sink.class)
@Slf4j
public class SendMessageController {

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
           log.info("接收的消息:{}",message.getPayload());
    }
}
