package com.cloud.controller;

import com.cloud.config.ApplicationContextConfig;
import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 15:37 2020/4/22
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    /*@GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }*/

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        ResponseEntity<CommonResult> ResponseEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        return ResponseEntity.getStatusCode().is2xxSuccessful() ? ResponseEntity.getBody():new CommonResult<>(444,"操作失败");
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return forEntity.getStatusCode().is2xxSuccessful() ? forEntity.getBody():new CommonResult<>(444,"操作失败");
    }

    @GetMapping("/consumer/payment/zipkin")
    public String getPaymentZipkin(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
    }

}
