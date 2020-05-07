package com.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.cloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 22:16 2020/5/2
 */

@Service
public class PaymentHystrixImpl implements PaymentHystrixService {


    public String paymentHystrix_ok(Long id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentHystrix_ok";
    }

    //失败
    @HystrixCommand(fallbackMethod = "paymentHystrix_timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")  //3秒钟以内就是正常的业务逻辑
    })
    public String paymentHystrix_timeOut(Long id) {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int a = 10 / 0;
        return "线程池：" + Thread.currentThread().getName() + "paymentHystrix_timeOut";
    }

    public String paymentHystrix_timeOutHandler(Long id) {
        return "线程池：" + Thread.currentThread().getName() + "8001端口报错，使用兜底方案：paymentHystrix_timeOutHandler";
    }

    //==============服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentServiceCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }
}
