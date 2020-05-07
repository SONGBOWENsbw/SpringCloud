package com.cloud.controller;

import com.cloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 22:21 2020/5/2
 */

@RestController
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id){
        String s = paymentHystrixService.paymentHystrix_ok(id);
        log.info("**********result:" + s);
        return s;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeOut(@PathVariable("id") Long id){
        String s = paymentHystrixService.paymentHystrix_timeOut(id);
        log.info("**********result:" + s);
        return s;
    }

    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentServiceCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }
}
