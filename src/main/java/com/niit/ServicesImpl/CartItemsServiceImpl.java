package com.niit.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CartItems;
import com.niit.music.dao.CartDao;
import com.niit.music.dao.CartItemsDao;
import com.niit.services.CartItemsService;

@Service
public class CartItemsServiceImpl implements CartItemsService{
	@Autowired
	private CartItemsDao cid;

	@Override
	@Transactional
	public void add(CartItems cartitems) {
		// TODO Auto-generated method stub
		cid.add(cartitems);
	}
	@Transactional
	@Override
	public void edit(CartItems cartitems) {
		// TODO Auto-generated method stub
		cid.edit(cartitems);
	}
	@Transactional
	@Override
	public void delete(int cartItems_id) {
		// TODO Auto-generated method stub
		cid.delete(cartItems_id);
	}
	@Transactional
	@Override
	public List getAllCartItems() {
		// TODO Auto-generated method stub
		return cid.getAllCartItems();
	}
	@Transactional
	@Override
	public CartItems getCartItems(int cartItems_id) {
		// TODO Auto-generated method stub
		return cid.getCartItems(cartItems_id);
	}
	@Transactional
	@Override
	public void update(CartItems cartitems) {
		// TODO Auto-generated method stub
		 cid.update(cartitems);
	}
	@Transactional
	@Override
	public int cartLength() {
		// TODO Auto-generated method stub
		return cid.cartLength();
	}

}

