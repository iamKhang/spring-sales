package com.lehoangkhang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lehoangkhang.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	@Query("SELECT c FROM Category c WHERE c.categoryName LIKE %?1%")
	public List<Category> findByName(String name);
}
