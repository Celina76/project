package com.niit.music.dao;

import java.util.List;

import com.niit.model.UserInfo;
/*creating interface for product dao class**/
public interface UserDao {
	/*creating the method for dao class->here insertrow,getting list,get by username**/
	public void insertRow(UserInfo user);
	public List<UserInfo> getUser_id();
	public UserInfo getByUserName(String username, String password);
	public List<UserInfo> getByUserName(String username);
	

}
