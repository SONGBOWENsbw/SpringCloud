package com.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 16:00 2020/4/29
 */

@RestController
@Slf4j
public class OrderController {

    public static final String INVIONK = "http://consul-provider-payment/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/consul")
    public String getPayment(){
        String result = restTemplate.getForObject(INVIONK + "payment/consul",String.class);
        return result;
    }

}
