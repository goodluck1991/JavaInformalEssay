package com.summary.design.proxy;

import com.summary.design.proxy.impl.UserDaoImpl;

/**
 * @Author: JiaoGuojun
 * @Description: 静态代理UserDaoProxy 代理 UserDao
 *  可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 *  2.缺点:
 *       因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 * @Date: Created in 14:09 2017/10/16
 */
public class UserDaoProxy implements UserDaoImpl {
    private UserDaoImpl userDao;

    public UserDaoProxy(UserDaoImpl userDao){
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("-------开启事务-------");
        userDao.save();
        System.out.println("-------结束事务-------");
    }

    @Override
    public void delete() {
        System.out.println("-------开启事务[delete]-------");
        userDao.delete();
        System.out.println("-------结束事务[delete]-------");
    }
}
