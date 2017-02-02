package com.niit.music.dao.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Shipping;
import com.niit.music.dao.ShippingDao;
@Repository
@Transactional
public class ShippingDaoImpl implements ShippingDao {
	@Autowired
	private SessionFactory session;
		
@Transactional
	@Override
	public void add(Shipping ship) {
	session.getCurrentSession().save(ship);
	}
@Transactional
	@Override
	public void edit(Shipping ship) {
		// TODO Auto-generated method stub
	session.getCurrentSession().update(ship);
	}

}
