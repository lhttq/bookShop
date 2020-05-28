package cn.lht.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: bookShop
 * @description: 登录跳转拦截
 * @author: LHT
 * @create: 2020-04-06 11:47
 **/
public class LoginSkipINterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,
                    response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.getRequestDispatcher("index.jsp").forward(request,
                    response);
    }
}
