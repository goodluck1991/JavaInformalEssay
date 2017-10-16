package com.test;

import com.summary.design.proxy.UserDao;
import com.summary.design.proxy.UserDaoProxy;
import com.summary.design.proxy.impl.UserDaoImpl;

/**
 * @Author: JiaoGuojun
 * @Description:
 * @Date: Created in 14:13 2017/10/16
 */
public class TestClass {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDao();
        UserDaoImpl userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
    }
}
