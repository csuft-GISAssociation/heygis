package com.heygis.service;

import com.heygis.beans.User;
import com.heygis.dao.UserDAOImpl;

public class RegisterService {
	UserDAOImpl udi = null;
	
	public int addUser(String account, String passWord, String nickName, String grade){
		udi = new UserDAOImpl();
		User user = new User(account, passWord, nickName, grade);
		return udi.addUser(user);
	}
}
