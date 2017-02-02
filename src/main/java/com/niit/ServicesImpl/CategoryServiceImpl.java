package com.niit.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.model.CategoryInfo;
import com.niit.music.dao.CategoryDao;
import com.niit.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void add(CategoryInfo category) {
		// TODO Auto-generated method stub
		categoryDao.add(category);
	}

	@Override
	public void edit(CategoryInfo category) {
		// TODO Auto-generated method stub
		categoryDao.edit(category);
	}

	@Override
	public void delete(int c_id) {
		// TODO Auto-generated method stub
		categoryDao.delete(c_id);
	}

	@Override
	public CategoryInfo getCategory(int c_id) {
		// TODO Auto-generated method stub
		return categoryDao.getCategory(c_id);
	}

	@Override
	public List getAllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategory();
	}

}
