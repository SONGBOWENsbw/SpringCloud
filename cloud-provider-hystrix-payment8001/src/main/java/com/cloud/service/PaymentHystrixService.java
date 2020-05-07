package com.cloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 22:15 2020/5/2
 */

public interface PaymentHystrixService {
    String paymentHystrix_ok(Long id);

    String paymentHystrix_timeOut(Long id);

    String paymentServiceCircuitBreaker(@PathVariable("id") Integer id);
}
