package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class registrationBean {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String birth;
	int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	
	public void saveInDb() {
		System.out.println("birth -- " + birth);
		Date d = Date.valueOf(birth);
		User u = new User(0, firstName, lastName, email, password, d, 0, "voter");
		try(UserDao dao = new UserDaoImpl()) {
			 count = dao.save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
}
