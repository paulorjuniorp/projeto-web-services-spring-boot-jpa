package com.paulorjuniorp.webservices.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulorjuniorp.webservices.springboot.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
