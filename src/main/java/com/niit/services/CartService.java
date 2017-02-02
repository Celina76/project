package com.niit.services;

import java.util.List;

import com.niit.model.Cart;

public interface CartService {
	public void add(Cart cart);
	public void edit(Cart cart);
	public void delete (int cart_id);
	public List getAll();
	Cart getCart(int cart_id);
}
