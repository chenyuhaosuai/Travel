package signle_Example;

/*
* 单例模式的第二种方法(鼎泰方法)
* */
public class single_second {
    private static  single_second instace = new single_second();
    private single_second(){}
    private static single_second getInstance(){
        return instace;
    }

}
