package com.heygis.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.heygis.beans.User;
import com.heygis.dao.UserDAOImpl;

public class LoginService {
	UserDAOImpl udi = null;
	
	public LoginService(){
		udi = new UserDAOImpl();
	}
	
	//登录验证
	public boolean login(String account,String password){
		ResultSet rs = udi.validateUser(account, password);
		try {
			if(rs.next()){
				if(password.equals(rs.getString("password"))){
					System.out.println("login ok");
					return true;
				}else{
					System.out.println("password wrong");
					return false;
				}
			}else{
				System.out.println("account not exist");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//得到user对象
	public User getUser(String account){
		return udi.getUser(account);
	}
}
