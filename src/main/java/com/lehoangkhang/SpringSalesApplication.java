package com.lehoangkhang;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lehoangkhang.services.StorageService;

@SpringBootApplication
public class SpringSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSalesApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}
}
