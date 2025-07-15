package com.interview.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.payment.entity.Payment;
import com.interview.payment.service.PaymentService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/payment")
public class PaymentController {

	
	@GetMapping("/ping")
	public void ping() {
		System.out.println("ping");
	}

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment) {
		return paymentService.doPayment(payment);
	}

	@GetMapping("/{OrderId}")
	public Payment findPaymentHistorybyOrderId(@PathVariable  int OrederId) {
		System.out.println("orderId : "+OrederId);
		return paymentService.findPaymentHistorybyOrderId(OrederId);
	}

}
