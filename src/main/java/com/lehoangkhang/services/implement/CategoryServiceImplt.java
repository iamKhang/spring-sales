package com.lehoangkhang.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lehoangkhang.models.Category;
import com.lehoangkhang.repository.CategoryRepository;
import com.lehoangkhang.services.CategoryService;

@Service
public class CategoryServiceImplt implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return this.categoryRepository.findAll();
	}

	@Override
	public Boolean createCategory(Category category) {
		try {
			categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean updateCategory(Category category) {
		try {
			categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteCategory(Integer id) {
		try {
			categoryRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Category findCategoryById(Integer id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public List<Category> searchCategory(String name) {
		
		return categoryRepository.findByName(name);
	}

	@Override
	public Page<Category> getAll(int page) {
		Pageable pageable = PageRequest.of(page-1, 2);
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Page<Category> searchCategory(String name, int page) {
		List<Category> list = this.searchCategory(name);
		Pageable pageable = PageRequest.of(page-1, 2);
		
		int start = (int)pageable.getOffset();
		int end = (start + pageable.getPageSize()) > list.size() ? list.size() : (start + pageable.getPageSize());
		list = list.subList(start, end);
		
		return new PageImpl<Category>(list, pageable, list.size());
	}

}
