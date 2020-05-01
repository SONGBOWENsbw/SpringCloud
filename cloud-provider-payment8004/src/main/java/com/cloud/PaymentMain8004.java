package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 17:13 2020/4/28
 */

@SpringBootApplication
@EnableDiscoveryClient  //该注解用于当使用zookeeper或consul当注册中心时的注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
