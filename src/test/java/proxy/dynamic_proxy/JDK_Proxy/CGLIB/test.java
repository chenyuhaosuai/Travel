package proxy.dynamic_proxy.JDK_Proxy.CGLIB;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class test {

    @Test
    public void test(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Crimitter.class);
        enhancer.setCallback( new LawerInterceptor());
        Crimitter c = (Crimitter) enhancer.create();
        c.speck();
    }
}
