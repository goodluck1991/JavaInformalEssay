package com.summary.design.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: JiaoGuojun
 * @Description:
 * @Date: Created in 14:38 2017/10/16
 */
public class ProxyFactory {
    public Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        if("save".equals(method.getName())){
                            System.out.println("------开始事务[save]-------");
                            returnValue = method.invoke(target,args);
                            System.out.println("------结束事务[save]-------");
                        }else if("delete".equals(method.getName())){
                            System.out.println("------开始事务[delete]-------");
                            returnValue = method.invoke(target,args);
                            System.out.println("------结束事务[delete]-------");
                        }
                        return returnValue;
                    }
                }
        );
    }

}
