package com.hjj.ben.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ben on 7/11/17.
 */
@Component
public class WebInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WebInterceptor.class);

    /**
     * 请求处理之前调用，进行一些前置初始化操作或者是对当前请求的一个预处理，
     * 也可以在这个方法中进行一些判断来决定请求是否要继续进行下去
     * @param request
     * @param response
     * @param handler
     * @return true：请求继续向下执行，false：请求结束
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("-----preHandle()-----");
        return super.preHandle(request, response, handler);
    }

    /**
     * 当前请求进行处理之后，也就是Controller 方法调用之后执行，
     * 但是它会在DispatcherServlet 进行视图返回渲染之前被调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("-----postHandle()-----");
        int status = response.getStatus();
        String uri = request.getRequestURI();
        logger.info("postHandle  uri: {} status: {}", uri, status);
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 整个请求结束之后执行，也就是在DispatcherServlet 渲染了对应的视图之后执行。
     * 可用于进行资源清理工作，系统日志的拦截
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("-----afterCompletion()-----");
        int status = response.getStatus();
        String uri = request.getRequestURI();
        logger.info("postHandle  uri: {} status: {}", uri, status);
    }
}
