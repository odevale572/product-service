package com.estore.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.estore.product.entity.Product;
import com.estore.product.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/upload")
public class DocumentController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/{id}")
	public ResponseEntity<Product> uploadImage(@PathVariable("id") int id,@RequestParam("imageFile") MultipartFile file){
		
		System.out.println("File name-" +file.getName());
		return new ResponseEntity<Product>(service.uploadImage(id, file), HttpStatus.CREATED);
	}
	
	@PostMapping
	public ResponseEntity<Product> uploadImageData(@RequestParam("imageFile") MultipartFile file){
		System.out.println("File name-" + file.getName());
		return new ResponseEntity<Product>(service.uploadImage(Integer.valueOf(file.getName().split("_")[1]), file), HttpStatus.CREATED);
	}
}
