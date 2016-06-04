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
	public boolean judgeEmail(String account){
		udi = new UserDAOImpl();
		return udi.judgeEmail(account);
	}
	public boolean judgeNickName(String nickName){
		udi = new UserDAOImpl();
		return udi.judgeNickName(nickName);
	}
}
