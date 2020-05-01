package com.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 15:43 2020/4/22
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //开启负载均衡
    public RestTemplate getRestTempLate() {
        return new RestTemplate();
    }

}
