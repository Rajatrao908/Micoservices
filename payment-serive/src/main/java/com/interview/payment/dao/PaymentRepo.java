package com.interview.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.payment.entity.Payment;

@Repository
public interface PaymentRepo extends  JpaRepository<Payment, Integer>{
	
	Payment findByOrderId(int OrderId);

}
