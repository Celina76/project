package com.niit.music.dao;

import java.util.List;


import com.niit.model.ProductInfo;
/*creating interface for dao class**/
public interface ProductDao {
	/*intializing the methods**/
public int add(ProductInfo product);
public List getList();

public ProductInfo getRowById(int id);

public int updateRow(ProductInfo product);

public int deleteRow(int id);
public List getAllProductfromCategory(String id);


}
