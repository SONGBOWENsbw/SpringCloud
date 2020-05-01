package com.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 17:18 2020/4/28
 */

@RestController
@Slf4j
public class paymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String getPaymentZK(){
        return "spring cloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
