package com.chubb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chubb.Repository.OrderRepository;
import com.chubb.request.Order;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {//to implement businessRules/ Logic
	@Autowired
	OrderRepository orderRepository;
	public void insertOrder(Order order) {
		orderRepository.save(order);
		log.debug(order.toString());
	}
}