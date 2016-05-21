package com.heygis.dao;

import java.sql.ResultSet;

import com.heygis.beans.User;
import com.heygis.dao.interfaces.UserDAO;

public class UserDAOImpl extends DAOSupport implements UserDAO{

	@Override
	public ResultSet validateUser(String account,String password){
		try {
			String sql = "select password from users where account=?";
			ResultSet rs = this.execQuery(sql, account);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addUser(User user){
		try {
			String account = user.getAccount();
			String password = user.getPassWord();
			String grade = user.getGrade();
			String sql1 = "insert into users (account,password) values (?,?)";
			String sql2 = "insert into users_info (account,grade) values (?,?)";
			int result1 = this.execUpdate(sql1,account,password);
			this.execUpdate(sql2,account,grade);
			if(result1 == 1){
				System.out.println("register OK");
			}else{
				System.out.println();
			}
			return result1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public User getUser(String account){
		try {
			User user = null;
			String sql = "select account,nickname,gender,grade,QQ,tel,selfintroduction,identity_id,icon_img from users_info where account=?";
			ResultSet rs = this.execQuery(sql,account);
			if(rs.next()){
				user = new User(rs.getString("account"),rs.getString("nickname"), rs.getString("grade"),
						rs.getString("gender"), rs.getString("QQ"), rs.getString("tel"),
						rs.getString("selfIntroduction"), rs.getString("icon_Img"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
