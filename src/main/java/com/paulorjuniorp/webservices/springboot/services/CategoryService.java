package com.paulorjuniorp.webservices.springboot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulorjuniorp.webservices.springboot.entities.Category;
import com.paulorjuniorp.webservices.springboot.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository CategoryRepository;
	
	public List<Category> findAll(){
		return CategoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		return CategoryRepository.findById(id).orElse(null);
	}
}
