package com.lg.warehouse.config;

import com.lg.warehouse.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 /* lin
 * 2018/7/27 10:01
 * <p>
 * getRequestDispatcher是服务器内部跳转，地址栏信息不变，只能跳转到web应用内的网页。
 * sendRedirect是页面重定向，地址栏信息改变，可以跳转到任意网页。
 * https://www.cnblogs.com/w-wfy/p/6387538.html
 * <p>
 * httpServletRequest.getRequestURI:返回URL中的一部分，从"/"开始，包括上下文，
 * 但不包括任意查询字符串
 */



@Component
public class UserLoginInterceptorBySpring extends HandlerInterceptorAdapter {

    // 在业务处理器处理请求之前被调用
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {
        // equalsIgnoreCase 与 equals的区别？
        System.out.println("-------preHandle-------");

        if ("GET".equalsIgnoreCase(request.getMethod())) {
            //RequestUtil.saveRequest();
        }

        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        String ip = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        System.out.println(request.getServerName());
        System.out.println(request.getServerPort());
        System.out.println("remoterAddr" + ip);
        System.out.println("requestUri: " + requestUri);
        System.out.println("contextPath: " + contextPath);
        System.out.println("remoteHost: " + remoteHost);

        HttpSession httpSession = request.getSession(false);

        if(httpSession==null){
            response.sendRedirect("/login");
            return false;
        }
        System.out.println("spring interceptor true");
        return  true;

    }


    // 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("-------afterHandle-------");
    }

}
