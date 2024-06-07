package com.lehoangkhang.services;

import java.util.List;

import com.lehoangkhang.models.Product;

public interface ProductService {
	List<Product> findAll();
	Product findById(Integer id);
	Boolean add(Product product);
	Boolean delete(Integer id);
	Boolean update(Product product);
}
