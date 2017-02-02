package com.niit.services;

import java.util.List;

import com.niit.model.UserInfo;
/*creating interface for service class**/
public interface DataServices {
	/*initialize the method**/
	public void insertRow(UserInfo user);

	public List<UserInfo> getUser_id();

	public UserInfo getByUserName(String username, String password);

}
