package com.interview.order_serive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.order_serive.common.Payment;
import com.interview.order_serive.common.TransactionRequest;
import com.interview.order_serive.common.TransactionResponse;
import com.interview.order_serive.entity.Order;
import com.interview.order_serive.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
		
		return orderservice.saveOrder(request);
	}

}
