package com.charles.springcloud.dao;

import com.charles.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Charles
 */
@Mapper
public interface PaymentDao {
    /**
     * 111
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 111
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);
}
