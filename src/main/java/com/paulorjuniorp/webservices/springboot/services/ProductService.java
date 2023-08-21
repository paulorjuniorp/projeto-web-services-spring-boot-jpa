package com.paulorjuniorp.webservices.springboot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.paulorjuniorp.webservices.springboot.entities.Product;
import com.paulorjuniorp.webservices.springboot.repositories.ProductRepository;
import com.paulorjuniorp.webservices.springboot.services.exceptions.DatabaseException;
import com.paulorjuniorp.webservices.springboot.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public Product insert(Product obj) {
		return productRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			productRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException de) {
			throw new DatabaseException(de.getMessage());
		}
	}
	
	public Product update(Long id, Product obj) {
		try {
			Product entity = productRepository.findById(id).orElse(null);
			if(entity != null) {
				updateData(entity, obj);
			}
			return productRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product entity, Product obj) {
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
		entity.setImgUrl(obj.getImgUrl());
	}
}
