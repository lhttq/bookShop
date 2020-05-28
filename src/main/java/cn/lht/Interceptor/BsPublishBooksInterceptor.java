package cn.lht.Interceptor;

import cn.lht.ThreadLocal.BsPublishBooksThreadLocal;
import cn.lht.entity.BsPassword;
import cn.lht.entity.BsPublishbooks;
import cn.lht.tools.GetURL;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: bookShop
 * @description: 查询出售书拦截器
 * @author: LHT
 * @create: 2020-04-04 20:08
 **/
public class BsPublishBooksInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 判断用户是否已登录，如果用户登录，则放行，如果用户没有登录，记下获取用户访问链接，
         * 并返回登录，登录成功后跳转到求情访问页面
         */
        boolean flog = false;
        //获取sessionID
        String sessionID = request.getRequestedSessionId();
        //获取用户
        BsPassword bsPassword = (BsPassword) request.getSession().getAttribute("user"+sessionID);
        //判断用户是否登录
        if(bsPassword != null){
            BsPublishbooks bsPublishBooks = new BsPublishbooks();
            bsPublishBooks.setBsLoginname(bsPassword.getBsLoginname());
            BsPublishBooksThreadLocal.set(bsPublishBooks);
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
