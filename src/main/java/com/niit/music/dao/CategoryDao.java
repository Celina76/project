package com.niit.music.dao;

import java.util.List;

import com.niit.model.CategoryInfo;

public interface CategoryDao {
public void add(CategoryInfo category);
public void edit(CategoryInfo category);
public void delete (int c_id);
public CategoryInfo getCategory(int c_id);
public List getAllCategory();
}
