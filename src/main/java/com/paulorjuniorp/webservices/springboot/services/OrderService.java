package com.paulorjuniorp.webservices.springboot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.paulorjuniorp.webservices.springboot.entities.Order;
import com.paulorjuniorp.webservices.springboot.repositories.OrderRepository;
import com.paulorjuniorp.webservices.springboot.services.exceptions.DatabaseException;
import com.paulorjuniorp.webservices.springboot.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Long id) {
		return orderRepository.findById(id).orElse(null);
	}
	
	public Order insert(Order obj) {
		return orderRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			orderRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException de) {
			throw new DatabaseException(de.getMessage());
		}
	}
	
	public Order update(Long id, Order obj) {
		try {
			Order entity = orderRepository.findById(id).orElse(null);
			if(entity != null) {
				updateData(entity, obj);
			}
			return orderRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Order entity, Order obj) {
		entity.setClient(obj.getClient());
		entity.setMoment(obj.getMoment());
		entity.setOrderStatus(obj.getOrderStatus());;
		entity.setPayment(obj.getPayment());;
	}
}
