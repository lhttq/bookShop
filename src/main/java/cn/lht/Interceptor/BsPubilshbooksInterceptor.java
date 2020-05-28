package cn.lht.Interceptor;

import cn.lht.entity.BsPassword;
import cn.lht.tools.GetURL;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: bookShop
 * @description: 卖书信息获取拦截
 * @author: LHT
 * @create: 2020-04-02 17:28
 **/
public class BsPubilshbooksInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flog = false;
        //获取sessionID
        String sessionID = request.getRequestedSessionId();
        //获取用户
        BsPassword bsPassword = (BsPassword) request.getSession().getAttribute("user"+sessionID);
        //判断用户是否登录
        if(bsPassword != null){
             request.getRequestDispatcher("/WEB-INF/pages/sellBook.jsp").forward(request,
                    response);
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
