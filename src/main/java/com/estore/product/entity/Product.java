package com.estore.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="product_id")
	private long productId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="price")
	private double price;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="company")
	private String company;
	
	@Column(name="year")
	private int year;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="content_type")
	private String contentType;
	
	@Column(name = "image", length = 999999999)
	private byte[] image;
	
	@Column(name = "userId")
	private String userId;
}



