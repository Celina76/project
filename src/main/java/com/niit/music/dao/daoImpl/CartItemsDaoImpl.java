package com.niit.music.dao.daoImpl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CartItems;
import com.niit.music.dao.CartItemsDao;
@Repository
public class CartItemsDaoImpl implements CartItemsDao{
@Autowired
SessionFactory session;
	@Override
	@Transactional
	public void add(CartItems cartitems) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(cartitems);
	}
	@Transactional
	@Override
	public void edit(CartItems cartitems) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(cartitems);
	}
	@Transactional
	@Override
	public void delete(int cartItems_id) {
		// TODO Auto-generated method s
		session.getCurrentSession().delete(getCartItems(cartItems_id));
	}
	@Transactional
	@Override
	public List getAllCartItems() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from CartItems").list();
	}
	@Transactional
	@Override
	public CartItems getCartItems(int cartItems_id) {
		// TODO Auto-generated method stub
		return (CartItems)session.getCurrentSession().get(CartItems.class, cartItems_id);
	}
	@Transactional
	@Override
	public void update(CartItems cartitems) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(cartitems);
	}
	@Transactional
	@Override
	public int cartLength() {
		// TODO Auto-generated method stub
		List c=session.getCurrentSession().createQuery("from CartItems").list();
		return c.size();
	}

}
