package com.serookie.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SentinelController {

    @GetMapping("/test1")
    public String testA(){
        return "......testA";
    }
    @GetMapping("/test2")
    public String testB(){
        return ".....testB";
    }
    @GetMapping("/test3")
    @SentinelResource(value = "test3",blockHandler = "dealHandler")
    public String test(@RequestParam(value = "p1",required = false) String p1,@RequestParam(value = "p2",required = false) String p2){
        return "sentinel的热点控制";
    }
    public String dealHandler(String p1, String p2, BlockException exception){
        return "sentinel已在控制中。。。。。";
    }
}
