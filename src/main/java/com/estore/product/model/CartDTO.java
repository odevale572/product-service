package com.estore.product.model;

import lombok.Data;

@Data
public class CartDTO {
	
	private String id;
	
	private String userId;
	
	private long productId;
	
	private String productName;
	private String productDescription;
	
	private double price;
	
	
	
	private long items;
	
	private String created;
	
	private String updated;
	
	private byte[] image;
}
