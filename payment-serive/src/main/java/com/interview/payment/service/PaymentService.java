package com.interview.payment.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.payment.dao.PaymentRepo;
import com.interview.payment.entity.Payment;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepo payRepo;

	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcess());
		payment.setTransactionId(UUID.randomUUID().toString());
		return payRepo.save(payment);
	}

	public String paymentProcess() {
		// paypal or any third party payment call
		return new Random().nextBoolean() ? "success" : "false";
	}

	public Payment findPaymentHistorybyOrderId(int OrderId) {
		return payRepo.findByOrderId(OrderId);
	}

}
