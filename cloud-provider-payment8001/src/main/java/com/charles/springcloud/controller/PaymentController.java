package com.charles.springcloud.controller;

import com.charles.springcloud.entities.Payment;
import com.charles.springcloud.entities.Result;
import com.charles.springcloud.entities.ResultCode;
import com.charles.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Charles
 */
@RestController
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/payment/create")
    public Result create(@RequestBody Payment payment){

        int count = paymentService.create(payment);
        System.out.println("*****!!!!!插入结果："+count+"111"+"222");
        if(count>0){
            Result result=new Result(ResultCode.SUCCESS,count);
            return result;
        }else{
            Result result=new Result(ResultCode.INSERT_IS_FAILED,null);
            return result;
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public Result getPaymentById(@PathVariable("id") Long id){
        System.out.println("hello");
        Payment payment=paymentService.getPaymentById(id);
        System.out.println("*****插入结果："+payment+"1111122222"+"222");

        if(payment!=null){
            Result result=new Result(ResultCode.SUCCESS,payment);
            return result;
        }else{
            Result result=new Result(ResultCode.PARAM_IS_INVALID,null);
            return result;
        }

    }
}
