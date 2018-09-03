package com.lg.warehouse.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lin
 * @ClassName HttpController
 * @date 2018/9/3 16:05
 * @description
 **/
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    StringBuffer requestURL;
    String requestURI;
    String method;
    Object[] argument;

    @Pointcut("execution(public * com.lg.warehouse.controller.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void requestBefore(JoinPoint joinPoint){

        ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();

        HttpServletRequest httpServletRequest=servletRequestAttributes.getRequest();

        requestURI=httpServletRequest.getRequestURI();
        requestURL=httpServletRequest.getRequestURL();

        method=httpServletRequest.getMethod();
        argument=joinPoint.getArgs();
        logger.info("---------Begin of request--------");
        logger.info("requestURL:"+requestURL);
        logger.info("requestURI:"+requestURI);
        logger.info("method:"+method);
        logger.info("argument:"+argument);


    }

    @After("pointCut()")
    public void requestAfter(){
        logger.info("---------End of request---------\n");
    }



}
