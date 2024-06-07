package com.lehoangkhang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lehoangkhang.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
