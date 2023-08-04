package com.paulorjuniorp.webservices.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulorjuniorp.webservices.springboot.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
