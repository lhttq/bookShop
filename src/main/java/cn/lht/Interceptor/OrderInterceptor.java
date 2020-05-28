package cn.lht.Interceptor;

import cn.lht.ThreadLocal.CartsThreadLocal;
import cn.lht.entity.BsCarts;
import cn.lht.entity.BsPassword;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: ssmDemo
 * @description:
 * @author: LHT
 * @create: 2020-03-28 14:56
 **/
public class OrderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        String httpSessionID = request.getRequestedSessionId();
        BsPassword bsPassword = (BsPassword) httpSession.getAttribute("user" + httpSessionID);
        BsCarts bsCarts = new BsCarts();
        bsCarts.setBsUserid(bsPassword.getBsUserid());
        bsCarts.setBsIscheck(1);
        CartsThreadLocal.set(bsCarts);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        CartsThreadLocal.remove();
    }
}
