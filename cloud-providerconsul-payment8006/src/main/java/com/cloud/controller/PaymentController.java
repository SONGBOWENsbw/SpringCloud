package com.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 15:51 2020/4/29
 */

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String getPaymentZK(){
        return "spring cloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
