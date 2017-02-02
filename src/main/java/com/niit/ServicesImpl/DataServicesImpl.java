package com.niit.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserInfo;
import com.niit.music.dao.UserDao;
import com.niit.services.DataServices;

@Service

public class DataServicesImpl implements DataServices {
	@Autowired/* autowire bean on the setter method  **/
	UserDao userDao;

	@Override
	@Transactional
/*method is created for adding the service using dao class**/
	public void insertRow(UserInfo user) {

		userDao.insertRow(user);
		System.out.println("Service is added");
	}
	/*method is created for  getting list the service using dao class**/
	@Override
	public List<UserInfo> getUser_id() {
		// TODO Auto-generated method stub
		return userDao.getUser_id();
	}
	/*method is created for getting row by username the service using dao class**/
	@Override
	public UserInfo getByUserName(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.getByUserName(username, password);
	}

}
