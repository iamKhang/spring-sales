package com.lehoangkhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lehoangkhang.models.Product;

@Repository
public interface ProductRepostory extends JpaRepository<Product, Integer>{
	
}
