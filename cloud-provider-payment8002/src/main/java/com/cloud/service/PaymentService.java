package com.cloud.service;

import com.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 20:50 2020/4/21
 */
public interface PaymentService {

    int create(Payment payment);
    Payment getPayment(@Param("id") long id);

}
