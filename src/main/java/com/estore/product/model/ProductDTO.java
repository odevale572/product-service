package com.estore.product.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
	
	private String description;
	private String productName;
	private double price;
	private int quantity;
	private String company;
	private int year;
	private String userId;
}
