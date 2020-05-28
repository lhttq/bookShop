package cn.lht.Interceptor;

import cn.lht.entity.BsPassword;
import cn.lht.entity.BsUsers;
import cn.lht.service.BsUsersService;
import cn.lht.tools.GetURL;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: bookShop
 * @description: 向学校书籍数据库添加数据
 * @author: LHT
 * @create: 2020-04-05 17:53
 **/
public class InbsStubooksInterceptor implements HandlerInterceptor {
     @Resource
    private BsUsersService bsUsersService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flog = false;
        BsUsers bsUsers = new BsUsers();
        //获取sessionID
        String sessionID = request.getRequestedSessionId();
        //获取用户
        BsPassword bsPassword = (BsPassword) request.getSession().getAttribute("user"+sessionID);
        //判断用户是否登录
        if(bsPassword != null){
              //获取用户信息
            bsUsers = bsUsersService.queryByBsLoginName(bsPassword.getBsLoginname());
            if(bsUsers != null){
                request.getRequestDispatcher("/WEB-INF/pages/stuSellBook.jsp").forward(request,
                    response);
            }else{
                //获取用户请求连接
            String url = GetURL.getFullURL(request);
            System.out.println(url);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("url",url);
            //返回信息完成页
             request.getRequestDispatcher("/WEB-INF/pages/info.jsp").forward(request,
                    response);
            }
        }else{
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
