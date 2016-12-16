package com.controller;

import com.bean.User;
import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	/*private String name;
	private String pwd;*/
	private User user=new User();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String loginUI() throws Exception{
		
		return "loginUI";
		
	}
	
	public String login() throws Exception{
	
		UserDAO userDAO=new UserDAO();
		User user=userDAO.getById(1);
	
		if(this.user.getUserName().equals(user.getUserName())&&this.user.getPassword().equals(user.getPassword())){
			return "success";
		}
		return "failed";
		
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPwd() {
//		return pwd;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}

	@Override
	public User getModel() {
		
		return this.user;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	
	
}
