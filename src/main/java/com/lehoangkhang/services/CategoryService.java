package com.lehoangkhang.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.lehoangkhang.models.Category;

public interface CategoryService {
	List<Category> getAllCategory();
	Boolean createCategory(Category category);
	Boolean updateCategory(Category category);
	Boolean deleteCategory(Integer id);
	Category findCategoryById(Integer id);
	
	List<Category> searchCategory(String name);
	
	
	Page<Category> getAll(int page);
	Page<Category> searchCategory(String name, int page);
}
