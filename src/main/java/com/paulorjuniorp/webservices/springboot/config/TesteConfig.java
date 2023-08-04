package com.paulorjuniorp.webservices.springboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.paulorjuniorp.webservices.springboot.entities.User;
import com.paulorjuniorp.webservices.springboot.repositories.UserRepository;

@Configuration
//@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Tony Hawk","tony@gmail.com", "998061005", "root3000");
		User user2 = new User(null, "Kratos da Silva", "krt@gmail.com","981112316", "user4000");
		
		userRepository.saveAll(Arrays.asList(user1,user2));
	}
	
	
}
