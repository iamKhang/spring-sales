package com.lehoangkhang.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lehoangkhang.models.Category;
import com.lehoangkhang.services.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public String index(Model model, @Param("categoryName") String categoryName) {
		List<Category> categories = null;
		if (categoryName != null) {
			categories = categoryService.searchCategory(categoryName);
			model.addAttribute("categoryName", categoryName);
		} else {
			categories = categoryService.getAllCategory();
		}
		
		model.addAttribute("categories", categories);
		return "admin/category/index";
	}

	@PostMapping("/add/save")
	public String save(Category category) {
		categoryService.createCategory(category);
		return "redirect:/admin/category";
	}

	@GetMapping("/add")
	public String add(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "admin/category/add";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Category category = categoryService.findCategoryById(id);
		model.addAttribute("category", category);
		return "admin/category/edit";
	}

	@PostMapping("/edit/save")
	public String update(@ModelAttribute Category category) {
		categoryService.updateCategory(category);
		return "redirect:/admin/category";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		categoryService.deleteCategory(id);
		return "redirect:/admin/category";
	}
	
	
}
