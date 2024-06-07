package com.lehoangkhang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lehoangkhang.services.StorageService;

@Controller
@RequestMapping("/upload-test")
public class TestUploadfile {
	
	@Autowired
	private StorageService storageService;
	
	@GetMapping
	public String uploadFile() {
		return "test-uploadfile";
	}
	
	@PostMapping
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		storageService.store(file);
		return "redirect:/upload-test";
	}	
}
