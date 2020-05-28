package cn.lht.Interceptor;

import cn.lht.ThreadLocal.BooksThreadLocal;
import cn.lht.ThreadLocal.StuBooksThreadLocal;
import cn.lht.entity.BsBooks;
import cn.lht.entity.BsPassword;
import cn.lht.entity.BsUsers;
import cn.lht.service.BsUsersService;
import cn.lht.tools.GetURL;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: bookShop
 * @description: 查询拦截
 * @author: LHT
 * @create: 2020-04-01 11:46
 **/
public class SearchInterceptor implements HandlerInterceptor {
    @Resource
    private BsUsersService bsUsersService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         boolean flog = false;
        //获取sessionID
        String sessionID = request.getRequestedSessionId();
        //获取书籍名称
        String bookName = request.getParameter("bsBookname");
        //处理书籍名称
        bookName = "%" + bookName + "%";
        //获取用户
        BsPassword bsPassword = (BsPassword) request.getSession().getAttribute("user"+sessionID);
         BsUsers bsUsers = new BsUsers();
        //判断用户是否登录
        if(bsPassword != null){
            //根据用户名查询用户信息
         bsUsers = bsUsersService.queryByBsLoginName(bsPassword.getBsLoginname());
         //获取用户所在的省份
            if(bsUsers != null){
                BsBooks bsBooks = new BsBooks();
            bsBooks.setBsProvince(bsUsers.getBsProvince());
            bsBooks.setBsBookname(bookName);
            //将对象放入线程域
            BooksThreadLocal.set(bsBooks);
            flog = true;
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
        }else {
             System.out.println("搜索检测登录拦截：拦截成功");
            //获取用户请求连接
            String url = GetURL.getFullURL(request);
            System.out.println(url);
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
        StuBooksThreadLocal.remove();
    }
}
