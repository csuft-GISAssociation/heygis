package com.heygis.service.interfaces;

import com.heygis.dto.User;

public interface UserService {

    /**
     * 判断登陆
     * @param account
     * @param password
     * @return
     */
    public boolean login(String account, String password);

    /**
     * 根据account获取用户Dto
     * @param account
     * @return
     */
    public User getUser(String account);

    /**
     * 更新个人信息里的头像地址
     * @param user
     * @return
     */
    public boolean updateImg(User user);

    /**
     * 保存头像文件
     * @param base64
     * @param user
     * @return
     */
    public boolean toImg(String base64, User user);

    /**
     * 完善个人信息
     * @param user
     * @return
     */
    public boolean fillInfo(User user);

    /**
     * 注册新用户
     * @param account
     * @param passWord
     * @param nickName
     * @param grade
     * @return
     */
    public int addUser(String account, String passWord, String nickName, String grade);

    /**
     * 判断邮箱是否重复
     * @param account
     * @return
     */
    public boolean judgeEmail(String account);

    /**
     * 判断昵称是否重复
     * @param nickName
     * @return
     */
    public boolean judgeNickName(String nickName);
}
