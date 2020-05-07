package com.cloud.controller;

import com.cloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 11:06 2020/5/3
 */

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globaFallback")
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id){
        return  orderHystrixService.paymentInfo_ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")  //3秒钟以内就是正常的业务逻辑
    })*/
    @HystrixCommand
    public String paymentInfo_timeOut(@PathVariable("id") Long id){
        return  orderHystrixService.paymentInfo_timeOut(id);
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Long id){
        return "系统繁忙或出错，请稍后再试";
    }

    public String globaFallback(){
        return "globa全局降级方法";
    }

}
