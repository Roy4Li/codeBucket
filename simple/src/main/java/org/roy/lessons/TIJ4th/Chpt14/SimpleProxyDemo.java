package org.roy.lessons.TIJ4th.Chpt14;

import java.lang.reflect.*;

/**
 * Created by lilei on 15/9/29.
 */

// 对外接口
interface Subject {
    void doSomething();
}

// 执行实体
class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("RealSubject "+" doSomething");
    }
}

// 代理类
class ProxyObject implements Subject {
    // 对执行实体的引用，以便使用执行实体
    private Subject realObject;
    public ProxyObject(Subject realObject){
        this.realObject = realObject;
    }
    //
    @Override
    public void doSomething() {
        // 调用前可以做些处理
        System.out.println("proxy : -----before-----");
        realObject.doSomething();
        // 调用后也可以做些处理
        System.out.println("proxy :-----after------");
        // Tip：已经是个简单的AOP实现了
    }
}



class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandler(Object obj){
        this.proxied = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("****proxy: "+proxy.getClass()+". method: "+method+". args: "+args);
        if(args != null){
            for (Object arg:args)
                System.out.println(" "+arg);
        }
        return method.invoke(proxied,args);
    }
}

public class SimpleProxyDemo{
    public static void consume(Subject i){
        i.doSomething();
    }

    public static void main(String[] args) {
        RealSubject real = new RealSubject();
        consume(real);
        consume(new ProxyObject(real));

        // 产生动态代理
        Subject proxy = (Subject)Proxy.newProxyInstance(
                Subject.class.getClassLoader(),
                new Class[]{Subject.class},
                new DynamicProxyHandler(real));
        consume(proxy);
    }
}
