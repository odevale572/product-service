package com.estore.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Controller and App
 * @author Onkar Prakash Devale
 *
 */
@SpringBootApplication
//@EnableEurekaClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
		
			@Override
			public void addCorsMappings(CorsRegistry registry) {
 				registry.addMapping("/product").allowedOrigins("http://localhost:4200");
			}
		
		};
	}

}
