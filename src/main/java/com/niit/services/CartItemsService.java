package com.niit.services;

import java.util.List;

import com.niit.model.CartItems;

public interface CartItemsService {
	public void add(CartItems cartitems);
	public void edit(CartItems cartitems);
	public void delete (int cartItems_id);
	public List getAllCartItems();
	CartItems getCartItems(int cartItems_id);
	public void update(CartItems cartitems);
	public int cartLength();
}
