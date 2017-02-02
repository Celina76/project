package com.niit.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;
import com.niit.music.dao.CartDao;
import com.niit.music.dao.CategoryDao;
import com.niit.services.CartService;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao cd;
@Transactional
	@Override
	public void add(Cart cart) {
		// TODO Auto-generated method stub
		cd.add(cart);

	}
@Transactional
	@Override
	public void edit(Cart cart) {
		// TODO Auto-generated method stub
		cd.edit(cart);

	}
@Transactional
	@Override
	public void delete(int cart_id) {
		// TODO Auto-generated method stub
		cd.delete(cart_id);
	
	}
@Transactional
	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return cd.getAll();
	}
@Transactional
	@Override
	public Cart getCart(int cart_id) {
		// TODO Auto-generated method stub
		return cd.getCart(cart_id);
	}
}
