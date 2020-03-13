package com.charles.springcloud.controller;

import com.charles.springcloud.entities.Payment;
import com.charles.springcloud.entities.Result;
import com.charles.springcloud.entities.ResultCode;
import com.charles.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Charles
 */
@RestController
public class PaymentController {
    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public Result create(@RequestBody Payment payment) {

        int count = paymentService.create(payment);
        System.out.println("*****!!!!!插入结果：" + count + ",serverPort:" + serverPort);
        if (count > 0) {
            Result result = new Result(ResultCode.SUCCESS,"serverPort:"+serverPort, count);
            return result;
        } else {
            Result result = new Result(ResultCode.INSERT_IS_FAILED, "serverPort:"+serverPort,null);
            return result;
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        System.out.println("hello");
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("*****插入结果：" + payment + ",serverPort:" + serverPort);

        if (payment != null) {
            Result result = new Result(ResultCode.SUCCESS, "serverPort:"+serverPort,payment);
            return result;
        } else {
            Result result = new Result(ResultCode.PARAM_IS_INVALID,"serverPort:"+serverPort, null);
            return result;
        }

    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element:" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
