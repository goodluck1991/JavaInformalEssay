package com.test;

import com.summary.design.proxy.*;
import com.summary.design.proxy.impl.UserDaoImpl;

/**
 * @Author: JiaoGuojun
 * @Description:
 * @Date: Created in 14:13 2017/10/16
 */
public class TestClass {
    public static void main(String[] args) {
        System.out.println("----------------------------静态代理--------------------------------------");

        UserDaoImpl userDao = new UserDao();
        UserDaoImpl userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
        userDaoProxy.delete();

        System.out.println("----------------------------静态代理--------------------------------------");

        UserDaoImpl user = new UserDao();
        ProxyFactory proxyFactory = new ProxyFactory(user);
        UserDaoImpl userDao1 = (UserDaoImpl)proxyFactory.getProxyInstance();
        userDao1.save();
        userDao1.delete();

        System.out.println("----------------------------代理Cglib--------------------------------------");
        Strudent target = new Strudent();
        Strudent strudent = (Strudent)new CglibProxyFactory(target).getProxyInstance();
        strudent.eat();
        strudent.learn();
    }
}
