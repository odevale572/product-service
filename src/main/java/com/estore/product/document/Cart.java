package com.estore.product.document;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Document("cart")
@Data
public class Cart {
	
	@MongoId
	private String id;
	
	private String userId;
	
	private long productId;
	
	private long items;
	 
	private String created;
	
	private String updated;
	
	private byte[] image;
}
