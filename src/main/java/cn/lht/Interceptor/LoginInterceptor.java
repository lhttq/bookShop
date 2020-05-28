package cn.lht.Interceptor;

import cn.lht.entity.BsPassword;
import cn.lht.service.BsPasswordService;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    BsPasswordService bsPasswordService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flog = false;
        //获取用户名和密码
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        BsPassword bsPassword = new BsPassword();
        bsPassword.setBsLoginname(username);
        List<BsPassword> list = bsPasswordService.queryAll(bsPassword);
        if(list != null){
             bsPassword = list.get(0);
        }
        System.out.println("登录拦截：执行了");
        if (bsPassword.getBsPassword().equals(password)){
            //获取session
            HttpSession session = request.getSession();
            //获取SessionID
            String sessionID = request.getRequestedSessionId();
            System.out.println(sessionID);
            //将用户登录信息放入session域
            session.setAttribute("user"+sessionID,bsPassword);
            //获取用户要访问的链接
            String url = (String) session.getAttribute("url");
            System.out.println(url);
            //跳转到用户之前要访问的链接
            if(url == null){
                response.sendRedirect("../index.jsp");
            }else{
                request.getRequestDispatcher(url).forward(request,response);
            }

        }
        return flog;
    }
}
