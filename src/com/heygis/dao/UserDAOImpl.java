package com.heygis.dao;

import java.sql.ResultSet;

import com.heygis.beans.User;
import com.heygis.dao.interfaces.UserDAO;

public class UserDAOImpl extends DAOSupport implements UserDAO{

	@Override
	public boolean validateUser(String account,String password){
		try {
			String sql = "select password from users where account=?";
			ResultSet rs = this.execQuery(sql, account);
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
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(this.conn.equals(null))
				this.close();
		}
		return false;
	}

	@Override
	public int addUser(User user){
		try {
			String account = user.getAccount();
			String password = user.getPassWord();
			String nickName = user.getNickName();
			String grade = user.getGrade();
			String sql1 = "insert into users (account,password) values (?,?)";
			String sql2 = "insert into users_info (account,nickname,grade) values (?,?,?)";
			int result1 = this.execUpdate(sql1,account,password);
			this.close();
			this.execUpdate(sql2,account,nickName,grade);
			this.close();
			if(result1 == 1){
				System.out.println("register scuessfully");
			}else{
				System.out.println("register failed");
			}
			return result1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(this.conn.equals(null))
				this.close();
		}
		return 0;
		
	}

	@Override
	public User getUser(String account){
		try {
			User user = null;
			String sql = "select uid,account,nickname,gender,grade,QQ,tel,selfintroduction,identity_id,icon_img from users_info where account=?";
			ResultSet rs = this.execQuery(sql,account);
			if(rs.next()){
				user = new User(rs.getString("uid"),rs.getString("account"),rs.getString("nickname"), rs.getString("grade"),
						rs.getString("gender"), rs.getString("QQ"), rs.getString("tel"),
						rs.getString("selfIntroduction"), rs.getString("icon_Img"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(this.conn.equals(null))
				this.close();
		}
		return null;
	}

}
