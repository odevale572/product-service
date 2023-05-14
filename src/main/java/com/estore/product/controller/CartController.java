package com.estore.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estore.product.cart.repository.CartRepository;
import com.estore.product.document.Cart;
import com.estore.product.model.CartDTO;
import com.estore.product.service.CartService;
import com.estore.product.service.ProductService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	ProductService productService;
	
	
	@PostMapping
	public ResponseEntity<String> addToCart(@RequestBody CartDTO cartDTO) {
		
		return new ResponseEntity<String>(cartService.saveToCart(cartDTO), HttpStatus.OK);
	}
	
	
	@GetMapping("/cartListByUserId/{userId}")
	public List<CartDTO> getCartDetails(@PathVariable("userId") String userId){
		
		List<CartDTO> cartByUserId = cartService.getCartsByUserId(userId);
		
		return cartByUserId;
	}
	
	
	@DeleteMapping ("/delete/{productId}/{items}")
	public boolean removeProductFromCart(@PathVariable("productId") String productId,
			@PathVariable("items") int items){
		
		boolean deleted = cartService.removeProductById(Long.valueOf(productId), items);
		
		return deleted;
	}
}
