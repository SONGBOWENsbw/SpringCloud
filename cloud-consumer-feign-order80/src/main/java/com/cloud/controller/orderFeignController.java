package com.cloud.controller;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import com.cloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 17:08 2020/5/2
 */

@RestController
@Slf4j
public class orderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @PostMapping("consumer/payment/create")
    public CommonResult<Payment> createPayment(Payment payment){
        return paymentFeignService.create(payment);
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPayment(id);
    }

    @GetMapping("consumer/payment/feign/timeout")
    public String getPaymentTimeOut(){
        return  paymentFeignService.getPaymentTimeOut();
    }

}
