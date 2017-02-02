package com.niit.music.dao;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.CartItems;

public interface CartItemsDao {
	public void add(CartItems cartitems);
	public void edit(CartItems cartitems);
	public void delete (int cartItems_id);
	public List getAllCartItems();
	CartItems getCartItems(int cartItems_id);
	void update(CartItems cartitems);
	public int cartLength();
}
