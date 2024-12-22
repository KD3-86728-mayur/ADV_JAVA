package com.jdbc.dao;

import java.util.List;

import com.jdbc.entities.User;

public interface UserDao extends AutoCloseable {

	List<User> findAllUsers() throws Exception;
	User findUserById(int id) throws Exception;
	User findUserByEmail(String email) throws Exception;
	int saveUser(User u) throws Exception;
	int updateUser(User u) throws Exception;
	
	// for Election Application
	int giveVote(int id) throws Exception;
}
