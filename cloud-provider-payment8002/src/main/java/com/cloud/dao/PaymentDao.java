package com.cloud.dao;

import com.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 20:31 2020/4/21
 */

@Mapper
public interface PaymentDao {
    int creat(Payment payment);

    Payment getPayment(@Param("id") long id);
}
