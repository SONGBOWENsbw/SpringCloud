package com.cloud.controller;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import com.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 20:56 2020/4/21
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******数据插入结果为：" + result);
        return result > 0 ? new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, result) : new CommonResult(444, "插入数据库失败", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPayment(id);
        log.info("*******数据查询结果为：" + payment + "********");
        return payment != null ? new CommonResult(200, "查询数据库成功,serverPort:" + serverPort, payment) : new CommonResult(444, "查询数据库失败" + id, null);
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("eureka服务有：" + service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info(service + "下的微服务有：" + instance.getInstanceId() + "\t 端口号为：" + instance.getPort());
            }
        }
        return discoveryClient;
    }

    @GetMapping("/payment/feign/timeout")
    public String getPaymentTimeOut(){

        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }

        return serverPort;
    }

}
