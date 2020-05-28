package cn.lht.ThreadLocal;

import cn.lht.entity.BsBooks;
import cn.lht.entity.BsCarts;

/**
 * @program: bookShop
 * @description: 图书线程
 * @author: LHT
 * @create: 2020-04-01 15:45
 **/
public class BooksThreadLocal {
    //将构造函数私有化，不让外面创建新对象，只能调用改类的方法
    private BooksThreadLocal(){ }
    private static final ThreadLocal<BsBooks> LOCAL = new ThreadLocal<BsBooks>();
    public static BsBooks get(){
        return LOCAL.get();
    }
    public static void set(BsBooks bsBooks){
        LOCAL.set(bsBooks);
    }
    public static void remove(){
        LOCAL.remove();
    }

}
