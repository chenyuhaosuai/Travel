package proxy.dynamic_proxy.JDK_Proxy.CGLIB;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LawerInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("从道德层面");
        methodProxy.invokeSuper( o,objects );
        System.out.println("从法律层面");
        return null;
    }
}
