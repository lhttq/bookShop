package cn.lht.Interceptor;

import cn.lht.entity.BsPassword;
import cn.lht.tools.GetURL;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InfoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Boolean flog = false;
        //获取用户要访问的链接
        String url = GetURL.getFullURL(request);
        //获取session并将url保存在session中
        HttpSession session =  request.getSession();
        session.setAttribute("url",url);
        //获取用户当前的sessionID
        String sessionID = request.getRequestedSessionId();
        BsPassword bsPassword = (BsPassword) session.getAttribute("user"+sessionID);
        System.out.println(bsPassword);
        if(bsPassword != null){
            flog = true;
        }else {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
        }
        return flog;
    }

}
