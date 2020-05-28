package cn.lht.ThreadLocal;

import cn.lht.entity.BsCarts;


public class CartsThreadLocal {
    //将构造函数私有化，不让外面创建新对象，只能调用改类的方法
    private CartsThreadLocal(){ }
    private static final ThreadLocal<BsCarts> LOCAL = new ThreadLocal<BsCarts>();
    public static BsCarts get(){
        return LOCAL.get();
    }
    public static void set(BsCarts bsCarts){
        LOCAL.set(bsCarts);
    }
    public static void remove(){
        LOCAL.remove();
    }


}
