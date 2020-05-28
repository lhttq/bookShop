package cn.lht.Interceptor;

import cn.lht.ThreadLocal.RegisterThreadLocal;
import cn.lht.entity.BsPassword;
import cn.lht.service.BsPasswordService;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class RegisterInterceptor implements HandlerInterceptor {
    @Resource
    BsPasswordService bsPasswordService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Boolean flog = false;
        Integer integer = 1;
        //获取用户名
        String username = request.getParameter("Username");
        BsPassword bsPassword = new BsPassword();
        bsPassword.setBsLoginname(username);
        //查询账户名是否存在
        List<BsPassword> list = bsPasswordService.queryAll(bsPassword);
        //如果用户不存在，插入用户信息
        if(list.size() == 0){
            request.setAttribute("msg",integer);
            //新建对象并保存到线程域
            BuildPass(request);
            flog = true;
        }else {
            //若用户存在，返回注册页
            integer = -1;
            request.setAttribute("msg",integer);
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }
        return flog;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion执行了");
        RegisterThreadLocal.remove();
    }

    /**
     * 获取IP
     * @param request
     * @return
     */
    public static String getIPAddress(HttpServletRequest request) {
        String ip = null;

        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     *新建bsBooksPassword
     * @param request
     */
    public void BuildPass(HttpServletRequest request){
        //获取系统时间
        Date date = new Date();
        //新建账号对象
        BsPassword bsPassword = new BsPassword();
        //向对象添加数据
        bsPassword.setBsLoginname(request.getParameter("Username"));
        bsPassword.setBsPassword(request.getParameter("Password"));
        bsPassword.setBsLastloginip(getIPAddress(request));
        bsPassword.setBsCreatetime(date);
        bsPassword.setBsLastlogintime(date);
        //将对象保存到线程域
        RegisterThreadLocal.set(bsPassword);
        System.out.println("用户名："+request.getParameter("Username"));
        System.out.println("密码："+request.getParameter("Password"));
        System.out.println("我执行了");
        System.out.println(bsPassword.getBsCreatetime());
    }

}
