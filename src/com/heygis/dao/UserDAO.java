package com.heygis.dao;

import java.sql.ResultSet;

import com.heygis.beans.User;

public interface UserDAO {
	public ResultSet validateUser(String account,String password);
	public int addUser(User user);
	public User getUser(String account);
}
