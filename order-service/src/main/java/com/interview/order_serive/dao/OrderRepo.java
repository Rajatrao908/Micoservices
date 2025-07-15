package com.interview.order_serive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.order_serive.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
