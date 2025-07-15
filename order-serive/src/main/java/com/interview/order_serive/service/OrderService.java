package com.interview.order_serive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.interview.order_serive.common.Payment;
import com.interview.order_serive.common.TransactionRequest;
import com.interview.order_serive.common.TransactionResponse;
import com.interview.order_serive.dao.OrderRepo;
import com.interview.order_serive.entity.Order;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private RestTemplate template;

	public TransactionResponse saveOrder(TransactionRequest request) {
		String message="";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		Payment paymentresponse=template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		System.out.println("paymentresponse.getPaymentStatus()============"+paymentresponse.getPaymentStatus());
		System.out.println("paymentresponse"+paymentresponse);
		
		message=paymentresponse.getPaymentStatus().equals("success")?"Payment Processing Successfull":"Payment Failed Api Error,Order added to cart";
		
		
		orderRepo.save(order);
		
		return new TransactionResponse(order,paymentresponse.getAmount(),paymentresponse.getTransactionId(),message);

	}

}
