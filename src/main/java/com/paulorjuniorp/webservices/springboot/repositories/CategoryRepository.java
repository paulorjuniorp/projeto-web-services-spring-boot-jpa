package com.paulorjuniorp.webservices.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulorjuniorp.webservices.springboot.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
