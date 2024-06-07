package com.lehoangkhang.services;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	void init();	
	
	void store(MultipartFile file);
}
