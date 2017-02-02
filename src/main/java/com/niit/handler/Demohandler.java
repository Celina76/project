
package com.niit.handler;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.binding.message.MessageBuilder;

import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.model.UserInfo;
import com.niit.model.UserRole;
import com.niit.services.DataServices;

@Component //adding basic annotation for craeting bean
public class Demohandler {
@Autowired //for adding the services of pojo class
DataServices ds;
	public UserInfo initFlow() //method is created for initflow to trigger the pojo class in web.xml 
	{
		System.out.println("triggering");
		return new UserInfo();
	}

	public String validateDetails(UserInfo user, MessageContext messageContext)//java validation for fields in the register page

	{
		System.out.println("validating");
		String status = "success";
		
		if (user.getFirstname().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("firstname").defaultText("firstname cannot be Empty").build());
			System.out.println("fname");
			status = "failure";
			
		}
		if (user.getLastname().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("lastname").defaultText("lastname cannot be Empty").build());
			status = "failure";
			System.out.println("lname");
		}
		if (user.getUsername().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("username").defaultText("username cannot be Empty").build());
			status = "failure";
			System.out.println("uname");
		}
		if (user.getEmail().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("email").defaultText("email cannot be Empty").build());
			status = "failure";
			System.out.println("email");
		}
		if (user.getPassword().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("password").defaultText("password cannot be Empty").build());
			status = "failure";
			System.out.println("pwd");
		}
		if (user.getConfirmpwd().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("confirmpwd")
					.defaultText("confirmpwd cannot be Empty").build());
			status = "failure";
			System.out.println("cpwd");
		}
		System.out.println(user.getFirstname());
		return status;
	}
	public String doRegister(UserInfo user) //method for inserting details in the database
	{
		System.out.println(user.getFirstname());
		UserRole ur=new UserRole();
		ur.setRole("ROLE_USER");
		ur.setUser_id(user);
		user.setEnabled(true);
		ds.insertRow(user);
		System.out.println("details are added");
		return "success";
	}
}
