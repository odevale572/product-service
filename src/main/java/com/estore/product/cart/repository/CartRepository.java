package com.estore.product.cart.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.estore.product.document.Cart;
import com.mongodb.client.result.UpdateResult;

@Repository
public class CartRepository {

	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public String saveToCart(Cart cart) {
		
		Query query = new Query(Criteria.where("userId").is(cart.getUserId()))
				.addCriteria(Criteria.where("productId").is(cart.getProductId()));
		
		try {
			Cart list = mongoTemplate.findOne(query, Cart.class, "cart");
			
			if(list!=null) {
				Update update = new Update();
				list.setItems(list.getItems() +1);
				update.set("items", list.getItems());
				
				mongoTemplate.updateFirst(query, update, Cart.class, "cart");
			} else {
				mongoTemplate.save(cart, "cart");
			}
			
		} catch (RuntimeException e) {
			System.out.println(e);
		}
		
		return "saved";
	}
	
	public List<Cart> getCartByUserId(String userId){
		List<Cart> cartList = new ArrayList<>();
		Query query = new Query();
		try {
			query.addCriteria(Criteria.where("userId").is(userId));
			
			cartList =  mongoTemplate.find(query, Cart.class, "cart");
		} catch (RuntimeException e) {
			System.out.println(e);
		}
		
		return cartList;
	}
	
	
	public void deleteProductById(long productId, int items) {
		Query query = new Query(Criteria.where("productId").is(productId));
		try {
			
			if(items == 1) {
				mongoTemplate.remove(query, "cart");
			} else {
				Update updateDef = new Update();
				updateDef.set("items", items-1);
				UpdateResult result =  mongoTemplate.updateFirst(query, updateDef, Cart.class, "cart");
				System.out.println(result);
			}
		} catch (RuntimeException e) {
			System.out.println(e);
		}
	}
	
	
}
