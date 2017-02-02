package com.niit.music.dao.daoImpl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.CategoryInfo;
import com.niit.music.dao.CategoryDao;

@Repository
public class CategoryDaoImpl implements CategoryDao{
@Autowired
private SessionFactory session;
	@Override
	@Transactional
	public void add(CategoryInfo category) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(category);

	}

	@Override
	@Transactional
	public void edit(CategoryInfo category) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(category);
	}

	@Override
	@Transactional
	public void delete(int c_id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getCategory(c_id));
	}
@Transactional
	@Override
	public CategoryInfo getCategory(int c_id) {
		// TODO Auto-generated method stub
		return (CategoryInfo)session.getCurrentSession().get(CategoryInfo.class, c_id);
	}
@Transactional
	@Override
	public List getAllCategory() {
		// TODO Auto-generated method stub
	return session.getCurrentSession().createQuery("from CategoryInfo").list();
	}
	

}
