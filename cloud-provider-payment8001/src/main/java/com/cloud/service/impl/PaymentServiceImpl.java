package com.cloud.service.impl;

import com.cloud.dao.PaymentDao;
import com.cloud.entities.Payment;
import com.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 20:51 2020/4/21
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.creat(payment);
    }

    @Override
    public Payment getPayment(long id) {
        return paymentDao.getPayment(id);
    }
}
