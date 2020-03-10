package com.charles.springcloud.service;

import com.charles.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Charles
 */
public interface PaymentService {

    /**
     * 111
     * @param payment
     * @return
     */
    int create(@Param(value = "payment") Payment payment);

    /**
     * 111
     * @param id
     * @return
     */
    Payment getPaymentById(@Param(value = "id") Long id);
}

