package com.lehoangkhang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lehoangkhang.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
