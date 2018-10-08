package com.heygis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.heygis.constants.UserConstant;
import com.heygis.dto.User;
import com.heygis.dao.interfaces.UserDAO;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends DAOSupport implements UserDAO {

    @Override
    public boolean validateUser(String account, String password) {
        try {
            this.openConn();
            String sql = "select password from users where account=?";
            ResultSet rs = this.execQuery(sql, account);
            if (rs.next()) {
//                String pw = EncoderByMd5(password);
                String pw = password;
                if (rs.getString("password").equals(pw)) {
                    System.out.println("heygis-log: login " + account + " login ok");
                    return true;
                } else {
                    System.out.println("heygis-log: login " + account + " password wrong");
                    return false;
                }
            } else {
                System.out.println("heygis-log: login " + account + " account not exist");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.openConn();
        }
        return false;
    }

    @Override
    public int addUser(User user) {//添加默认的性别，头像，个人介绍
        try {
            String account = user.getAccount();
            //String password = EncoderByMd5(user.getPassWord());
            String password = user.getPassWord();
            String sql1 = "insert into users (account,password) values (?,?)";
            this.openConn();
            int result1 = this.execUpdate(sql1, account, password);
            if (result1 == 1) {
                int uid = this.LAST_INSERT_ID();
                return uid;
            } else {
                return UserConstant.WRONG_UID;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return UserConstant.WRONG_UID;
    }

    @Override
    public int addUserInfo(User user) {
        try {
            int uid = user.getUid();
            String account = user.getAccount();
            String nickName = user.getNickName();
            String grade = user.getGrade();
            String sql2 = "insert into users_info (uid,account,nickname,grade) values (?,?,?,?)";
            this.openConn();
            int updateNum = this.execUpdate(sql2, uid, account, nickName, grade);
            if (updateNum == 1) {
                int insertUid = this.LAST_INSERT_ID();
                return insertUid;
            } else {
                return UserConstant.WRONG_UID;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return UserConstant.WRONG_UID;
    }

    @Override
    public User getUser(String account) {
        try {
            this.openConn();
            User user = null;
            String sql="select * from users_info where uid in(select uid from users u where u.account=?);";
//            String sql = "select uid,account,nickname,gender,grade,QQ,tel,selfintroduction,identity_id,icon_img from users_info where account=?";
            ResultSet rs = this.execQuery(sql, account);
            if (rs.next()) {
//				System.out.println("user已经填充");
                user = new User(rs.getInt("uid"),
                        rs.getString("account"),
                        rs.getString("nickname"),
                        rs.getString("grade"),
                        rs.getString("gender"),
                        rs.getString("QQ"),
                        rs.getString("tel"),
                        rs.getString("selfIntroduction"),
                        rs.getString("icon_Img"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return null;
    }

    @Override
    public boolean judgeEmail(String account) {
        try {
            this.openConn();
            boolean bool = false;
            String sql = "select * from users where account=?";
            ResultSet rs = this.execQuery(sql, account);
            bool = !rs.next();
            return bool;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return false;
    }

    @Override
    public boolean judgeNickName(String nickName) {
        boolean bool = false;
        String sql = "select * from users_info where nickname=?";
        this.openConn();
        ResultSet rs = this.execQuery(sql, nickName);
        try {
            bool = !rs.next();
            this.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }

    @Override
    public boolean fillUserInfo(User user) {
        //boolean bool = false;
        String sql = "update users_info set nickname=?,grade=?,selfintroduction=?,gender=?,QQ=?,tel=? where uid=?";
        this.openConn();
        int result = this.execUpdate(sql, user.getNickName(), user.getGrade(), user.getSelfIntroduction(), user.getGender(), user.getQQ(), user.getTel(), user.getUid());
        this.close();
        //System.out.println(user.getAccount());
        //System.out.println(result);
        if (result == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateIconImg(User user) {
        String icon_img = "/heygis_img/icon/" + user.getAccount() + "_img.jpg";//这儿要改成图片地址路径
        String sql = "UPDATE users_info SET icon_img = ? WHERE account = ?";
        this.openConn();
        int result = this.execUpdate(sql, icon_img, user.getAccount());
        //System.out.println(result);
        this.close();
        if (result == 1) {
            return true;
        }
        return false;
    }

}
