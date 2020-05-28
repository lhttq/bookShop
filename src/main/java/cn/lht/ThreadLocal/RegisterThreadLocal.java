package cn.lht.ThreadLocal;

import cn.lht.entity.BsPassword;

public class RegisterThreadLocal  {
    //把构造函数私有，外面不能new，只能通过下面两个方法操作
    private RegisterThreadLocal(){

    }
    private static final ThreadLocal<BsPassword> LOCAL = new ThreadLocal<BsPassword>();

    public static BsPassword get() {
        return LOCAL.get();
    }
    public static void set(BsPassword bsPassword){
        LOCAL.set(bsPassword);;
    }
    public static void remove(){
        LOCAL.remove();
    }
}
