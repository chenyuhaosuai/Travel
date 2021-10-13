package signle_Example;

public class single {
    /*
    * 单例模式：静态内部类的方法
    * */

    private static class single_example{
        private static final single instance = new single();
    }
    private single(){}
    private static final single getInstance(){
        return single_example.instance;
    }
}
