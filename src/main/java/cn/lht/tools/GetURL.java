package cn.lht.tools;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: bookShop
 * @description: 获取连接
 * @author: LHT
 * @create: 2020-04-01 22:17
 **/
public class GetURL {
    //将构造函数私有化，不让外面创建新对象，只能调用改类的方法
    private GetURL(){ }
       //获取用户要访问的链接
    public static String getFullURL(HttpServletRequest request) {
        String url = request.getServletPath();
        if (request.getQueryString() != null) {
            url =  url + "?" + request.getQueryString();
        }
        return url;
    }
}
