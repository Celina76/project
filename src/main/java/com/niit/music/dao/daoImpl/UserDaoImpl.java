package com.niit.music.dao.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Shipping;
import com.niit.model.UserInfo;
import com.niit.model.UserRole;
import com.niit.music.dao.UserDao;
/*enabling transaction and for creating bean in repository @Repository is used**/
@EnableTransactionManagement
@Repository
/*creating the class implementing methods in interface using keyword implements**/
public class UserDaoImpl implements UserDao {
	/*autowiring the session factory and creating the references variable**/
	@Autowired
	SessionFactory sessionFactory;

	@Override
	/*transactional enabling to store in database**/
	@Transactional
	/*implementing method for save the details**/
	public void insertRow(UserInfo user) {

		Session session = sessionFactory.openSession();
		user.setEnabled(true);
		UserRole ur = new UserRole();
		
		
		ur.setUser_id(user);
		ur.setRole("ROLE_USER");

		session.save(user);
		session.save(ur);

		System.out.println("in Dao impl");

	}
	/*implementing method for get list**/
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserInfo> getUser_id() {

		return (List<UserInfo>) sessionFactory.getCurrentSession().createQuery("from UserInfo").list();

	}
	/*implementing method for getting row by user name**/
	@Override
	@Transactional
	public UserInfo getByUserName(String username, String password) {
		return (UserInfo) sessionFactory.getCurrentSession()
				.createQuery("from USERINFO where username=? and password=? where username=?").list();
	}
	@Override
	public List<UserInfo> getByUserName(String username) {
	
		// TODO Auto-generated method stub  String Query="from User where username='"+username+"'";
		  @SuppressWarnings("unchecked")
		   List<UserInfo> productList = sessionFactory.getCurrentSession().createQuery(username).list();//Query
		 
		  return productList;
	
	}

}