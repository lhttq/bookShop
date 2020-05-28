package cn.lht.ThreadLocal;

import cn.lht.entity.BsPublishbooks;

/**
 * @program: bookShop
 * @description: 售书对象
 * @author: LHT
 * @create: 2020-04-04 20:04
 **/
public class BsPublishBooksThreadLocal {
    //将构造函数私有化，不让外面创建新对象，只能调用改类的方法
    private BsPublishBooksThreadLocal(){ }
    private static final ThreadLocal<BsPublishbooks> LOCAL = new ThreadLocal<BsPublishbooks>();
    public static BsPublishbooks get(){
        return LOCAL.get();
    }
    public static void set(BsPublishbooks bsPublishbooks){
        LOCAL.set(bsPublishbooks);
    }
    public static void remove(){
        LOCAL.remove();
    }
}
