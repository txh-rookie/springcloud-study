package com.serookie.springcoud.config.filter;

import cn.hutool.core.date.DateUnit;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.serookie.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * 自定义网关但过滤器
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("请求网关进入····· 时间:{}", new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if(username==null){
            log.info("用户名不能为空,找不到该用户");
//            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            Result<Object> result = new Result<>();
            result.setCode(400);
            result.setMessage("请先登陆");
            try {
                byte[] bytes = JSON.toJSONString(result).getBytes("utf-8");
                DataBufferFactory dataBufferFactory = exchange.getResponse().bufferFactory();
                DataBuffer wrap = dataBufferFactory.wrap(bytes);
                return exchange.getResponse().writeWith(Mono.just(wrap));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return exchange.getResponse().setComplete();
        }
        log.info("username:{} 鉴权成功.",username);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
