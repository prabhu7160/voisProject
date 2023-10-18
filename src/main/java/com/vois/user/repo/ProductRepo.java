package com.vois.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vois.user.entity.Products;

public interface ProductRepo extends JpaRepository<Products, Integer> {
	

//		Optional<Products> findByProductName(String email);
	}