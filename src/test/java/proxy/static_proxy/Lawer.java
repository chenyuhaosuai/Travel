package proxy.static_proxy;

public class Lawer implements  Person{
    private Crimitter crimitter;
    public Lawer(Crimitter crimitter){
        this.crimitter = crimitter;
    }

    @Override
    public void speak() {
        System.out.println("重道德层面");
        crimitter.speak();
        System.out.println("从法律层面");
    }
}
