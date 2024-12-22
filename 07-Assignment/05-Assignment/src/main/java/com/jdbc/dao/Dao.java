package com.jdbc.dao;

import java.sql.Connection;

import com.jdbc.utils.DbUtil;

public abstract class Dao implements AutoCloseable
{
	protected Connection con;

	public Dao() throws Exception {
		con = DbUtil.getConnection();
	}

	@Override
	public void close() throws Exception {
		con.close();
	}
}
