package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 17:43 2020/4/21
 */
@SpringBootApplication
@EnableEurekaClient
public class PayMentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8002.class,args);
    }
}
