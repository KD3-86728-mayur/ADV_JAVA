package com.jdbc.daoImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.Dao;
import com.jdbc.dao.UserDao;
import com.jdbc.entities.User;

public class UserDaoImpl extends Dao implements UserDao {

	private PreparedStatement findUser;
	private PreparedStatement findUserById;
	private PreparedStatement findUserByEmail;
	private PreparedStatement saveUser;
	private PreparedStatement updateUser;
	private PreparedStatement giveVote;

	public UserDaoImpl() throws Exception {
		super(); // call dao class default constructor and make a connection.

		String findUsers = "select * from users";
		findUser = con.prepareStatement(findUsers);

		String findById = "select * from users where id=?";
		findUserById = con.prepareStatement(findById);

		String findByEmail = "select * from users where email=?";
		findUserByEmail = con.prepareStatement(findByEmail);

		String sqlSave = "INSERT INTO users (first_name, last_name, email, password, dob, status, role) VALUES(?, ?, ?, ?, ?, ?, ?)";
		saveUser = con.prepareStatement(sqlSave);

		String updateUserSql = "update users set first_name=?, last_name=?, email=?, password=?, dob=?, status=?, role=? where id=?";
		updateUser = con.prepareStatement(updateUserSql);

		String giveYourVote = "update users set status=1 where id=?";
		giveVote = con.prepareStatement(giveYourVote);

	}
	

	@Override
	public void close() throws Exception {
		giveVote.close();
		findUserByEmail.close();
		findUserById.close();
		findUser.close();
		super.close(); // close connection from dao class.
	}

	@Override
	public List<User> findAllUsers() throws Exception {
		ArrayList<User> userList = new ArrayList<User>();
		ResultSet rs = findUser.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String email = rs.getString("email");
			String password = rs.getString("password");
			Date birth = rs.getDate("dob");
			int status = rs.getInt("status");
			String role = rs.getString("role");
			User u = new User(id, firstName, lastName, email, password, birth, status, role);
			userList.add(u);
		}
		return userList;
	}

	@Override
	public User findUserById(int id) throws Exception {
		findUserById.setInt(1, id);
		ResultSet rs = findUserById.executeQuery();

		if (rs.next()) {
			id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String email = rs.getString("email");
			String password = rs.getString("password");
			Date birth = rs.getDate("dob");
			int status = rs.getInt("status");
			String role = rs.getString("role");
			User user = new User(id, firstName, lastName, email, password, birth, status, role);
			return user;
		}

		return null;
	}

	@Override
	public User findUserByEmail(String email) throws Exception {
		findUserByEmail.setString(1, email);
		ResultSet rs = findUserByEmail.executeQuery();

		if (rs.next()) {
			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			email = rs.getString("email");
			String password = rs.getString("password");
			Date birth = rs.getDate("dob");
			int status = rs.getInt("status");
			String role = rs.getString("role");
			User user = new User(id, firstName, lastName, email, password, birth, status, role);
			return user;
		}

		return null;
	}

	@Override
	public int saveUser(User u) throws Exception {
		saveUser.setString(1, u.getFirstName());
		saveUser.setString(2, u.getLastName());
		saveUser.setString(3, u.getEmail());
		saveUser.setString(4, u.getPassword());
		saveUser.setDate(5, u.getBirth());
		saveUser.setInt(6, u.getStatus());
		saveUser.setString(7, u.getRole());
		int count = saveUser.executeUpdate();
		return count;
	}

	@Override
	public int updateUser(User u) throws Exception {
		updateUser.setString(1, u.getFirstName());
		updateUser.setString(2, u.getLastName());
		updateUser.setString(3, u.getEmail());
		updateUser.setString(4, u.getPassword());
		updateUser.setDate(5, u.getBirth());
		updateUser.setInt(6, u.getStatus());
		updateUser.setString(7, u.getRole());
		updateUser.setInt(8, u.getId());
		int count = updateUser.executeUpdate();
		return count;
	}

	
	@Override
	public int giveVote(int id) throws Exception {
		giveVote.setInt(1, id);
		int res = giveVote.executeUpdate();
		return res;
	}

}
