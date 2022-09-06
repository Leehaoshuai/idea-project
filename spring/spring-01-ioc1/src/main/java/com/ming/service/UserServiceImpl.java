package com.ming.service;

import com.ming.dao.UserDao;
import com.ming.dao.UserDaoImpl;
import com.ming.dao.UserDaoMysqlImpl;
import com.ming.dao.UserDaoOracleImpl;

public class UserServiceImpl implements UserService{

    private UserDao userDao;
///*    原方法，需要反复修改业务实现代码 从而数据访问层的变量的创建  主动创建对象
//        控制权在程序员，
//        使用set注入后，程序不再具有主动性，变成了被动接受的对象
//        这种思想从本质上解决了问题，我们程序员不用再去管理对象的创建了
//        耦合性大大降低，只要专注于业务的实现
//    private UserDao userDao = new UserDaoImpl();
//    private UserDao userDao = new UserDaoMysqlImpl();
//    private UserDao userDao = new UserDaoOracleImpl();*/
//
    // 利用set进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
