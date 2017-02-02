package com.niit.music.dao.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Cart;
import com.niit.model.CategoryInfo;
import com.niit.music.dao.CartDao;
@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	private SessionFactory session;
	@Transactional
	@Override
	public void add(Cart cart) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(cart);
	}
	@Transactional
	@Override
	public void edit(Cart cart) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(cart);
	}
	@Transactional
	@Override
	public void delete(int cart_id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getCart(cart_id));
	}
	@Transactional
	@Override
	public Cart getCart(int cart_id) {
		// TODO Auto-generated method stub
		return (Cart)session.getCurrentSession().get(Cart.class, cart_id);
	}
	@Transactional
	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Cart").list();
	}

}
