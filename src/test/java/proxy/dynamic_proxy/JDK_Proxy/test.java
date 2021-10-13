package proxy.dynamic_proxy.JDK_Proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;


public class test {

    @Test
    public void test(){
        Crimitter c = new Crimitter();
        Lawer lawer = new Lawer( c );
        Person proxyInstance = (Person) Proxy.newProxyInstance( lawer.getClass().getClassLoader(), c.getClass().getInterfaces(), lawer );
        proxyInstance.speak();
    }
}
