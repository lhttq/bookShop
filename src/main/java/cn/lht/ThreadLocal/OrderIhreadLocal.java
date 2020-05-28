package cn.lht.ThreadLocal;

import cn.lht.entity.BsOrder;

/**
 * @program: bookShop
 * @description: 订单对象线程
 * @author: LHT
 * @create: 2020-04-13 21:04
 **/
public class OrderIhreadLocal {
      //将构造函数私有化，不让外面创建新对象，只能调用改类的方法
    private OrderIhreadLocal(){ }
    private static final ThreadLocal<BsOrder> LOCAL = new ThreadLocal<BsOrder>();
    public static BsOrder get(){
        return LOCAL.get();
    }
    public static void set(BsOrder bsOrder){
        LOCAL.set(bsOrder);
    }
    public static void remove(){
        LOCAL.remove();
    }
}
