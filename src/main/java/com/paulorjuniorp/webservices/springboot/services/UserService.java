package com.paulorjuniorp.webservices.springboot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulorjuniorp.webservices.springboot.entities.User;
import com.paulorjuniorp.webservices.springboot.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Integer id) {
		User user = this.findById(id);
		if (user != null) {
			userRepository.delete(user);
		}
	}
	
	public User update(Integer id, User obj) {
		User entity = userRepository.findById(id).orElse(null);
		if(entity != null) {
			updateData(entity, obj);
		}
		return userRepository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
