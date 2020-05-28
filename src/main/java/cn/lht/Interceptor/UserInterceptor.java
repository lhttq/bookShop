package cn.lht.Interceptor;

import cn.lht.entity.BsPassword;
import cn.lht.tools.GetURL;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: ssmDemo
 * @description: 用户信息拦截器
 * @author: LHT
 * @create: 2020-03-29 15:21
 **/
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String httpsSessionID = request.getRequestedSessionId();
        HttpSession httpSession = request.getSession();
        BsPassword bsPassword = (BsPassword) httpSession.getAttribute("user" + httpsSessionID);
        if (bsPassword == null) {
            String url = GetURL.getFullURL(request);
            httpSession.setAttribute("url",url);
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,
                    response);
        }else{
        String bsLoginName = bsPassword.getBsLoginname();
        System.out.println(bsLoginName);
        System.out.println("用户拦截执行了");
        request.getRequestDispatcher("SelectByUserLoginName?bsLoginname=" +bsLoginName).forward(request,response);
             return true;
        }
        return false;
    }
}
