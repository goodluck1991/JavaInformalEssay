package com.summary.design.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: JiaoGuojun
 * @Description:
 * @Date: Created in 15:24 2017/10/16
 */
public class CglibProxyFactory implements MethodInterceptor{
    public Object target;

    public CglibProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("---proxy start----");
        Object returnValue = methodProxy.invoke(target,objects);
        System.out.println("---proxy end----");
        return returnValue;
    }
}
