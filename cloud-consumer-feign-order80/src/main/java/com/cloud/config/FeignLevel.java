package com.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 17:45 2020/5/2
 */

@Configuration
public class FeignLevel {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

