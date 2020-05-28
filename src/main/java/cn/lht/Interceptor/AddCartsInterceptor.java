package cn.lht.Interceptor;

import cn.lht.entity.BsPassword;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCartsInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flog = false;
        //注：如果是ajax请求，则请求头部会有“x-requested-with”
        String requestType = request.getHeader("X-Requested-With");
        //获取session并将url保存在session中
        HttpSession session =  request.getSession();
        //获取sessionID
        String sessionID = request.getRequestedSessionId();
        //获取登录信息
        BsPassword bsPassword = (BsPassword) session.getAttribute("user"+sessionID);
        //判断是否是ajax请求
        if ("XMLHttpRequest".equals(requestType)){
            if(bsPassword == null){
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
            }
            System.out.println("拦截成功");
            flog = true;
        }
        return flog;
    }
}
