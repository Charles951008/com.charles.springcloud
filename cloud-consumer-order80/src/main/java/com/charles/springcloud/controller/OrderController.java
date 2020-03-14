package com.charles.springcloud.controller;

import com.charles.springcloud.entities.Payment;
import com.charles.springcloud.entities.Result;
import com.charles.springcloud.entities.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Charles
 */
@RestController
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    //public static final String PAYMENT_URL = "http://localhost:8001";

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public Result create(Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, Result.class);

    }

    @GetMapping("/consumer/payment/get/{id}")
    public Result getPayment(@PathVariable("id") Long id) {

        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, Result.class);

    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public Result getPayment2(@PathVariable("id") Long id){
        ResponseEntity<Result> entity=restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, Result.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            log.info("Successfully connected!!!");
            return entity.getBody();
        }else{
            log.error("Failed to connect!!!");
            return new Result(ResultCode.SEARCH_NOTHING,null);
        }
    }
}
