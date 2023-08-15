package com.paulorjuniorp.webservices.springboot.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.paulorjuniorp.webservices.springboot.entities.User;
import com.paulorjuniorp.webservices.springboot.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> users = userService.findAll();
		
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id){
		User user = userService.findById(id);
		
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user){
		User usuario = userService.insert(user);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
}
