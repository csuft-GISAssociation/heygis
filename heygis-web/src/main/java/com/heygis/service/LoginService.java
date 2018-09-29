package com.heygis.service;


import com.heygis.dao.interfaces.UserDAO;
import com.heygis.dto.User;
import com.heygis.dao.UserDAOImpl;

public class LoginService {
    UserDAO udi = null;

    public LoginService() {
        udi = new UserDAOImpl();
    }

    public boolean login(String account, String password) {
        return udi.validateUser(account, password);
    }

    public User getUser(String account) {
        return udi.getUser(account);
    }

    public int addUser(User user) {
        return udi.addUser(user);
    }
}
