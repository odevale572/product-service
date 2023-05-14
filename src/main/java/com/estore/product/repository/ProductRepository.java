package com.estore.product.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estore.product.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	
	public List<Product> findAll();
	
	public Product findById(int id);
	
	public Product findByProductId(long id);
	
	public Product save(Product order);
}
