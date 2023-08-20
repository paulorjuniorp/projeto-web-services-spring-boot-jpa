package com.paulorjuniorp.webservices.springboot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.paulorjuniorp.webservices.springboot.entities.Category;
import com.paulorjuniorp.webservices.springboot.repositories.CategoryRepository;
import com.paulorjuniorp.webservices.springboot.services.exceptions.DatabaseException;
import com.paulorjuniorp.webservices.springboot.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
	
	public Category insert(Category obj) {
		return categoryRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			categoryRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException de) {
			throw new DatabaseException(de.getMessage());
		}
	}
	
	public Category update(Long id, Category obj) {
		try {
			Category entity = categoryRepository.findById(id).orElse(null);
			if(entity != null) {
				updateData(entity, obj);
			}
			return categoryRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());
	}
}
