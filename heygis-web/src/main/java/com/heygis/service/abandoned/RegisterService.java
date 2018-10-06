package com.heygis.service.abandoned;

import com.heygis.dao.interfaces.UserDAO;
import com.heygis.dto.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户注册相关，预备迁移到UserService
 */
public class RegisterService {

    @Autowired
    UserDAO udi;

    public int addUser(String account, String passWord, String nickName, String grade) {
        User user = new User(account, passWord, nickName, grade);
        return udi.addUser(user);
    }

    public boolean judgeEmail(String account) {
        return udi.judgeEmail(account);
    }

    public boolean judgeNickName(String nickName) {
        return udi.judgeNickName(nickName);
    }
}
