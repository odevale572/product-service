package com.estore.product.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.product.cart.repository.CartRepository;
import com.estore.product.document.Cart;
import com.estore.product.entity.Product;
import com.estore.product.model.CartDTO;

@Service
public class CartService {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartRepository repo;
	
	public String saveToCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		BeanUtils.copyProperties(cartDTO, cart);
		
		return repo.saveToCart(cart);
	}
	
	public List<CartDTO> getCartsByUserId(String userId){
		
		List<CartDTO> cartList = new ArrayList<CartDTO>();
		
		List<Cart> cartByUserId = repo.getCartByUserId(userId);
		
		for(Cart cart: cartByUserId) {
			CartDTO dto = new CartDTO();
			Product findById = productService.findById(cart.getProductId());
			
			BeanUtils.copyProperties(cart, dto);
			dto.setImage(productService.decompressBytes(findById.getImage()));
			dto.setProductDescription(findById.getDescription());
			dto.setProductName(findById.getProductName());
			dto.setPrice(findById.getPrice());
			cartList.add(dto);
		}
		
		return cartList;
	}
	
	
	public boolean removeProductById(long productId, int items){
		repo.deleteProductById(productId, items);
		return true;
	}
}
