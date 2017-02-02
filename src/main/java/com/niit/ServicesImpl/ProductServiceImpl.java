package com.niit.ServicesImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ProductInfo;
import com.niit.music.dao.ProductDao;
import com.niit.services.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductDao pd;
	@Override
    @Transactional
	public int add(ProductInfo product) {
		return pd.add(product);
		
	}

	@Override
	@Transactional
	public List getList() {
		
		return pd.getList();
	}

	@Override
    @Transactional
	public ProductInfo getRowById(int id) {
		
		return pd.getRowById(id);
	}

	@Override
    @Transactional
	public int updateRow(ProductInfo product) {
	return	pd.updateRow(product);
		
	}

	@Override
	@Transactional
	public int deleteRow(int id) {
		return pd.deleteRow(id);
		
	}
	@Transactional
	public List getAllProductfromCategory(String id) {
		return pd.getAllProductfromCategory(id);
	}
}
