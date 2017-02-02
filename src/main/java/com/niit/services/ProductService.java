package com.niit.services;

import java.util.List;

import com.niit.model.ProductInfo;
/*creating interface for product service class**/
public interface ProductService {
	/*initialize the methods in the service class**/
	public int add(ProductInfo product);
	public List getList();

	public ProductInfo getRowById(int id);

	public int updateRow(ProductInfo product);

	public int deleteRow(int id);
	public List getAllProductfromCategory(String id);

}
