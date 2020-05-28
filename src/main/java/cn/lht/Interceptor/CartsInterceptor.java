package cn.lht.Interceptor;

import cn.lht.ThreadLocal.CartsThreadLocal;
import cn.lht.entity.BsCarts;
import cn.lht.entity.BsPassword;
import cn.lht.service.BsCartsService;
import cn.lht.tools.GetURL;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartsInterceptor implements HandlerInterceptor {
    @Resource
    private BsCartsService bsCartsService;
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
            BsCarts bsCarts = new BsCarts();
            bsCarts.setBsUserid((Integer) bsPassword.getBsUserid());
            //查询购物车物品是否存在，如果存在数量加一，如果不存在加入购物车
            CartsThreadLocal.set(bsCarts);
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
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        CartsThreadLocal.remove();
        System.out.println("物品信息查询成功");
    }
}
