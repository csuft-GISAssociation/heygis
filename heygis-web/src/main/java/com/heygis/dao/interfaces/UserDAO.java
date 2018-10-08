package com.heygis.dao.interfaces;

import com.heygis.dto.User;

public interface UserDAO {
    public boolean validateUser(String account, String password);

    public int addUser(User user);

    /**
     * 注册时插入用户信息（是insert）
     * @param user
     * @return
     */
    public int addUserInfo(User user);

    /**填充个人信息，个人中心的完善个人信息（是update）
     * @param user
     * @return
     */
    public boolean fillUserInfo(User user);

    public User getUser(String account);

    public boolean judgeEmail(String account);

    public boolean judgeNickName(String nickName);

    public boolean updateIconImg(User user);
}
