package com.paulorjuniorp.webservices.springboot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulorjuniorp.webservices.springboot.entities.Order;
import com.paulorjuniorp.webservices.springboot.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository OrderRepository;
	
	public List<Order> findAll(){
		return OrderRepository.findAll();
	}
	
	public Order findById(Long id) {
		return OrderRepository.findById(id).orElse(null);
	}
}
