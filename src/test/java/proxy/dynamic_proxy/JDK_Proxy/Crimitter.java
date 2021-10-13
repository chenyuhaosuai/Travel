package proxy.dynamic_proxy.JDK_Proxy;

public class Crimitter implements Person{
    @Override
    public void speak() {
        System.out.println("我没有犯罪！！！！！");
    }
}
