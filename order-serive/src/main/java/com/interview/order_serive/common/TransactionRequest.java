package com.interview.order_serive.common;

import com.interview.order_serive.entity.Order;

public class TransactionRequest {

	private Order order;
	private Payment payment;

	public TransactionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionRequest(Order order, Payment payment) {
		super();
		this.order = order;
		this.payment = payment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
