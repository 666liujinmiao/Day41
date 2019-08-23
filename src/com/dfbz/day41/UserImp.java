package com.dfbz.day41;

/** 数据访问层  */
public class UserImp implements UserService {
    private UserDao userDao = new UserDao();

    @Override
    public User login(String username, String password) {
        //依赖于dao层
        User user = userDao.findUser(username,password);
        //业务方法：登录
        return user;
    }
}
