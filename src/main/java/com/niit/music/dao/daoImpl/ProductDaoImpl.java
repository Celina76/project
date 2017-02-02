package com.niit.music.dao.daoImpl;

import java.io.Serializable;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ProductInfo;
import com.niit.music.dao.ProductDao;
/*enabling transaction and for creating bean in repository @Repository is used**/
@EnableTransactionManagement
@Repository
/*creating the class implementing methods in interface using keyword implements**/
public class ProductDaoImpl implements ProductDao {
	/*autowiring the session factory and creating the refernces variable**/
@Autowired
SessionFactory ss;
/*transactional enabling to store in database**/
@Transactional
@Override
/*implementing method for save the details**/
public int add(ProductInfo product) {
	
	
		  Session session = ss.openSession();
		  Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(product);
		  tx.commit();
		  Serializable id = session.getIdentifier(product);
		  session.close();
		return (Integer) id;  
	
}
@Transactional
@Override
/* implementing for the method list**/
public List getList() {
	Session session = ss.openSession();
	 List list = session.createQuery("from ProductInfo").list();
			    
			  session.close();
			  return list;
	

}
@Transactional
@Override
/*implementing method for getting row by id**/
public ProductInfo getRowById(int id) {
	
	 Session session = ss.openSession();
	  ProductInfo prod = (ProductInfo) session.load(ProductInfo.class, id);
	  return prod;

	
}
@Transactional
@Override
/*implementing method for updating the details**/
public int updateRow(ProductInfo product) {
		Session session = ss.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(product);
	  tx.commit();
	  Serializable id = session.getIdentifier(product);
	  session.close();
	  return (Integer) id;
}
@Transactional
@Override
/*implementing method for deleting the row**/
public int deleteRow(int id) {
	
	Session session = ss.openSession();
	  Transaction tx = session.beginTransaction();
	  ProductInfo product = (ProductInfo) session.load(ProductInfo.class, id);
	  session.delete(product);
	  tx.commit();
	  Serializable ids = session.getIdentifier(product);
	  session.close();
	  return (Integer) ids;
	 }
@Transactional
public List getAllProductfromCategory(String id) {
	
	String query="from ProductInfo where CATEGORY_NAME=:output";
	//Session session = ss.openSession();
	List image=ss.getCurrentSession().createQuery(query).setParameter("output",id).list();
	return image;
}
}

