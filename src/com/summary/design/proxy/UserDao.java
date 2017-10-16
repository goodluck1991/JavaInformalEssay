package com.summary.design.proxy;

import com.summary.design.proxy.impl.UserDaoImpl;

/**
 * @Author: JiaoGuojun
 * @Description:
 * @Date: Created in 14:06 2017/10/16
 */
public class UserDao implements UserDaoImpl{
    @Override
    public void save() {
        System.out.println("-----数据保存成功------");
    }

    @Override
    public void delete() {
        System.out.println("-----数据删除成功-------");
    }
}
