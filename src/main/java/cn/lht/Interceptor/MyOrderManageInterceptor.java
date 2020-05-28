package cn.lht.Interceptor;

import cn.lht.ThreadLocal.OrderIhreadLocal;
import cn.lht.entity.BsOrder;
import cn.lht.entity.BsPassword;
import cn.lht.tools.GetURL;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: bookShop
 * @description: 我的订单
 * @author: LHT
 * @create: 2020-04-13 20:58
 **/
public class MyOrderManageInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         boolean flog = false;
        //获取sessionID
        String sessionID = request.getRequestedSessionId();
        //获取用户
        BsPassword bsPassword = (BsPassword) request.getSession().getAttribute("user"+sessionID);
        //判断用户是否登录
        if(bsPassword != null){
               //获取用户Id
            Integer userId = bsPassword.getBsUserid();
            //将用户ID传入订单控制类
                //新建订单对象
            BsOrder bsOrder = new BsOrder();
                //将用户id放入订单对象中
            bsOrder.setBsUserid(userId);
                //将订单对象放入线程域
            OrderIhreadLocal.set(bsOrder);
            //放行
            flog = true;
        }else {
            System.out.println("拦截成功");
            //获取用户请求连接
            String url = GetURL.getFullURL(request);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("url",url);
            //返回到登录界面
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,
                    response);
        }
        return flog;

    }
}
