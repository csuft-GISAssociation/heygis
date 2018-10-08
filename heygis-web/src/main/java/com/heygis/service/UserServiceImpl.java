package com.heygis.service;

import com.heygis.common.util.EncodeUtil;
import com.heygis.common.util.HexAndBytesUtil;
import com.heygis.constants.PathConstant;
import com.heygis.constants.UserConstant;
import com.heygis.dao.interfaces.UserDAO;
import com.heygis.dto.User;
import com.heygis.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.OutputStream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public boolean login(String account, String password) {
        //密码在前端做MD5，得到16进制字符串，在此转回为字节
        byte[] pwBytes = HexAndBytesUtil.HEXtoBytes(password);
        //将字节使用Base64编码
        password = EncodeUtil.encoderByBase64(pwBytes);
        return userDAO.validateUser(account, password);
    }

    @Override
    public User getUser(String account) {
        return userDAO.getUser(account);
    }

    @Override
    public boolean updateImg(User user) {
        return userDAO.updateIconImg(user);
    }

    @Override
    public boolean toImg(String base64, User user) {
        if (base64 == null) { // 图像数据为空
            return false;
        }
        try {
            // Base64解码
            byte[] bytes = EncodeUtil.dncoderByBase64(base64);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            String path = PathConstant.TOMCAT_HOME + PathConstant.ICON_IMG_PATH + user.getAccount() + "_img.jpg";
            OutputStream out = new FileOutputStream(path);
            out.write(bytes);
            out.flush();
            out.close();
            if (updateImg(user)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean fillInfo(User user) {
        return userDAO.fillUserInfo(user);
    }

    @Override
    public int addUser(String account, String passWord, String nickName, String grade) {
        //密码在前端做MD5，得到16进制字符串，在此转回为字节
        byte[] pwBytes = HexAndBytesUtil.HEXtoBytes(passWord);
        //将字节使用Base64编码
        passWord = EncodeUtil.encoderByBase64(pwBytes);
        User user = new User(account, passWord, nickName, grade);
        //插入users表
        int uid = userDAO.addUser(user);
        if (uid != UserConstant.WRONG_UID) {
            user.setUid(uid);
            //插入users_info表
            int infoUid = userDAO.addUserInfo(user);
            if (infoUid != UserConstant.WRONG_UID) {
                System.out.println("heygis-log: register " + account + " register scuessfully");
            }else{
                System.out.println("heygis-log: register " + account + " register failed");
            }
        } else {
            System.out.println("heygis-log: register " + account + " register failed");
        }
        return uid;
    }

    @Override
    public boolean judgeEmail(String account) {
        return userDAO.judgeEmail(account);
    }

    @Override
    public boolean judgeNickName(String nickName) {
        return userDAO.judgeNickName(nickName);
    }
}
