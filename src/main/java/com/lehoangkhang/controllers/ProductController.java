package com.lehoangkhang.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lehoangkhang.models.Category;
import com.lehoangkhang.models.Product;
import com.lehoangkhang.services.CategoryService;
import com.lehoangkhang.services.ProductService;
import com.lehoangkhang.services.StorageService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/product")
	public String product(Model model) {
		List<Product> products = productService.findAll();	
		
		model.addAttribute("products", products);	
		return "admin/product/index";
	}
	
	
	
	@GetMapping("/product/add")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		
		
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("categories", categories);
		
		return "admin/product/add";
	}
	
	@PostMapping("/product/add")
	public String save(@ModelAttribute Product product, @RequestParam("fileImage") MultipartFile file) {
	    storageService.store(file);
	    String fileName = file.getOriginalFilename();
	    product.setImage(fileName);
	    if(productService.add(product)) {
	    	return "redirect:/admin/product";
	    }
	    return "admin/product/add";
	}
	
	@GetMapping("/product/edit/{id}")
	public String editProduct(Model model, @PathVariable("id") Integer id) {
	    Product product = productService.findById(id);
	    model.addAttribute("product", product);

	    List<Category> categories = categoryService.getAllCategory();
	    model.addAttribute("categories", categories);

	    return "admin/product/edit";
	}
	
	@PostMapping("/product/edit/save")
	public String saveEdit(@ModelAttribute Product product, @RequestParam("fileImage") MultipartFile file) {
		String fileName = file.getOriginalFilename();
		boolean isEmty = fileName == null || fileName.trim().length() == 0;
		if (!isEmty) {
			storageService.store(file);
			product.setImage(fileName);
		}
		if (productService.update(product)) {
			return "redirect:/admin/product";
		}
		return "admin/product/edit";
	}
}
