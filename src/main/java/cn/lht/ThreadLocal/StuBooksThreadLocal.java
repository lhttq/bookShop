package cn.lht.ThreadLocal;

import cn.lht.entity.BsBooks;
import cn.lht.entity.BsStubooks;

/**
 * @program: bookShop
 * @description: 学校图书线程
 * @author: LHT
 * @create: 2020-04-01 22:03
 **/
public class StuBooksThreadLocal {
    //将构造函数私有化，不让外面创建新对象，只能调用改类的方法
    private StuBooksThreadLocal(){ }
    private static final ThreadLocal<BsStubooks> LOCAL = new ThreadLocal<BsStubooks>();
    public static BsStubooks get(){
        return LOCAL.get();
    }
    public static void set(BsStubooks bsStubooks){
        LOCAL.set(bsStubooks);
    }
    public static void remove(){
        LOCAL.remove();
    }
}
