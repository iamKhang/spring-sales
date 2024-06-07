package com.lehoangkhang.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lehoangkhang.models.Product;
import com.lehoangkhang.repository.ProductRepostory;
import com.lehoangkhang.services.ProductService;

@Service
public class ProductServiceImplt implements ProductService {

	@Autowired
	private ProductRepostory productRepostory;
	@Override
	public List<Product> findAll() {
		return productRepostory.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return productRepostory.findById(id).get();
	}

	@Override
	public Boolean add(Product product) {
		try {
			productRepostory.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			productRepostory.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean update(Product product) {
		try {
			productRepostory.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
