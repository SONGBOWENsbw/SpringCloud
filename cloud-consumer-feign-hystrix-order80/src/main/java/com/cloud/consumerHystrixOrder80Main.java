package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 10:51 2020/5/3
 */

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class consumerHystrixOrder80Main {
    public static void main(String[] args) {
        SpringApplication.run(consumerHystrixOrder80Main.class,args);
    }
}
