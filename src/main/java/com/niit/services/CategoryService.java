package com.niit.services;

import java.util.List;

import com.niit.model.CategoryInfo;

public interface CategoryService {
	public void add(CategoryInfo category);
	public void edit(CategoryInfo category);
	public void delete (int c_id);
	public CategoryInfo getCategory(int c_id);
	public List getAllCategory();
}
