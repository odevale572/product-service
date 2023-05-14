package com.estore.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.estore.product.entity.Product;
import com.estore.product.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping
	public ResponseEntity<Product> registerProduct(@RequestBody Product order){
		
		return new ResponseEntity<Product>(service.registerProduct(order), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product order){
		return new ResponseEntity<Product>(service.updateProduct(order), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> list = new ArrayList<Product>();
		list = service.findAll();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable(name = "id") int id){
		
		return new ResponseEntity<Product>(service.findById(id), HttpStatus.OK);
	}
}
