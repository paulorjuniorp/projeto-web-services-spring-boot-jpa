package com.paulorjuniorp.webservices.springboot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulorjuniorp.webservices.springboot.entities.Product;
import com.paulorjuniorp.webservices.springboot.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository ProductRepository;
	
	public List<Product> findAll(){
		return ProductRepository.findAll();
	}
	
	public Product findById(Long id) {
		return ProductRepository.findById(id).orElse(null);
	}
}
