package com.java.beans;

import java.sql.Date;

import com.jdbc.dao.UserDao;
import com.jdbc.daoImpl.UserDaoImpl;
import com.jdbc.entities.User;

public class RegisterBeans 
{
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String birth;
	private int status;
	private String role;
	private boolean userStatus;
	
	public RegisterBeans() {
	}

	public RegisterBeans(int id, String firstName, String lastName, String email, String password, String birth, int status,
			String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birth = birth;
		this.status = status;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public void register() {
		Date date = Date.valueOf(birth); // convert string date into sql date.
		User user = new User(0, firstName, lastName, email, password, date, status, role);
		System.out.println(user);
		try(UserDao userDao = new UserDaoImpl()){
			int saveUser = userDao.saveUser(user);
			if(saveUser==1)
				this.userStatus = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", birth=" + birth + ", status=" + status + ", role=" + role + "]";
	}

}
