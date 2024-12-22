package com.java.beans;

import com.jdbc.dao.UserDao;
import com.jdbc.daoImpl.UserDaoImpl;
import com.jdbc.entities.User;

public class LoginBeans 
{
	private String email;
	private String password;
	private User user;
	public LoginBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoginBeans(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	@Override
	public String toString() {
		return "LoginBeans [email=" + email + ", password=" + password + "]";
	}

	
	public void login() {
		try(UserDao uDao = new UserDaoImpl()){
			User u= uDao.findUserByEmail(email);
			System.out.println("user"+u);
			if(u != null && u.getPassword().equals(password)) {
				this.user = u;
			}else {
				this.user=null;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
