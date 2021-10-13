package proxy.dynamic_proxy.JDK_Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Lawer implements InvocationHandler {

    //1.注入被代理对象
    private Crimitter crimitter;
    public Lawer(Crimitter crimitter){
        this.crimitter = crimitter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("从道德层面");
        method.invoke(crimitter,args);
        System.out.println("从法律层面");
        return null;
    }
}
