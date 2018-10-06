package com.heygis.service.abandoned;


import com.heygis.dao.interfaces.UserDAO;
import com.heygis.dto.User;
import com.heygis.common.util.EncodeUtil;
import com.heygis.common.util.HexAndBytesUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户登陆相关，预备迁移到UserService
 */
public class LoginService {

    @Autowired
    UserDAO udi;

    public LoginService() {
    }

    public boolean login(String account, String password) {
        //密码在前端做MD5，得到16进制字符串，在此转回为字节
        byte[] pwBytes = HexAndBytesUtil.HEXtoBytes(password);
        //将字节使用Base64编码
        password = EncodeUtil.encoderByBase64(pwBytes);
        return udi.validateUser(account, password);
    }

    public User getUser(String account) {
        return udi.getUser(account);
    }

    public int addUser(User user) {
        return udi.addUser(user);
    }
}
