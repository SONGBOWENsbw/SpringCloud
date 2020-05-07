package com.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 15:03 2020/5/5
 */

@Component
public class paymentFallbackService implements OrderHystrixService {

    @Override
    public String paymentInfo_ok(Long id) {
        return "paymentFallbackService:paymentInfo_ok";
    }

    @Override
    public String paymentInfo_timeOut(Long id) {
        return "paymentFallbackService:paymentInfo_timeOut";
    }
}
