package com.paulorjuniorp.webservices.springboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;

import com.paulorjuniorp.webservices.springboot.entities.Category;
import com.paulorjuniorp.webservices.springboot.entities.Order;
import com.paulorjuniorp.webservices.springboot.entities.User;
import com.paulorjuniorp.webservices.springboot.entities.enums.OrderStatus;
import com.paulorjuniorp.webservices.springboot.repositories.CategoryRepository;
import com.paulorjuniorp.webservices.springboot.repositories.OrderRepository;
import com.paulorjuniorp.webservices.springboot.repositories.UserRepository;

@Configuration
//@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Tony Hawk","tony@gmail.com", "998061005", "root3000");
		User user2 = new User(null, "Kratos da Silva", "krt@gmail.com","981112316", "user4000");
		
		Order o1 = new Order(null, Instant.parse("2023-08-04T19:53:07Z"), user1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2023-08-05T03:42:10Z"), user2, OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.parse("2023-08-05T15:21:22Z"), user1, OrderStatus.WAITING_PAYMENT);
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		userRepository.saveAll(Arrays.asList(user1,user2));
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
	}
	
	
}
