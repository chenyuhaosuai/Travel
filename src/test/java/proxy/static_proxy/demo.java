package proxy.static_proxy;

import org.junit.Test;


public class demo {

    @Test
    public void test(){
        Crimitter zs = new Crimitter();
        Lawer zs_lawer = new Lawer(zs);
        zs_lawer.speak();
    }
}
