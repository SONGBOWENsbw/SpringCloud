package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 18:41 2020/5/7
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GetewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GetewayMain9527.class,args);
    }
}
