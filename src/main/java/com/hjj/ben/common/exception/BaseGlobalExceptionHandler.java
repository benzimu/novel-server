package com.hjj.ben.common.exception;

import com.google.common.base.Throwables;
import com.hjj.ben.utils.Ajax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by ben on 7/10/17.
 */
public class BaseGlobalExceptionHandler {
    protected static final Logger logger = null;
    protected static final String DEFAULT_ERROR_MESSAGE = "系统忙，请稍后再试";

    protected ModelAndView handlerError(HttpServletRequest req,
                                        HttpServletResponse res,
                                        Exception e,
                                        String viewName, HttpStatus status)
            throws Exception {
        getLogger().info("-----base:handlerError()-----");
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
            throw e;
        String errorMsg = e.getMessage() != null ? e.getMessage() : DEFAULT_ERROR_MESSAGE;

        String errorStack = Throwables.getStackTraceAsString(e);

        getLogger().error("Request: {} raised {}", req.getRequestURI(), errorStack);
        if (Ajax.isAjax(req)) {
            return handlerAjaxError(res, errorMsg, status);
        }
        return handlerViewError(req.getRequestURL().toString(), errorStack, errorMsg, viewName);

    }

    protected ModelAndView handlerAjaxError(HttpServletResponse res,
                                            String errorMessage,
                                            HttpStatus status)
            throws Exception {
        res.setCharacterEncoding("UTF-8");
        res.setStatus(status.value());
        PrintWriter pw = res.getWriter();
        pw.print(errorMessage);
        pw.flush();
        return null;
    }

    protected ModelAndView handlerViewError(String url,
                                            String errorStack,
                                            String errorMessage,
                                            String viewName)
            throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", errorStack);
        mav.addObject("url", url);
        mav.addObject("message", errorMessage);
        mav.addObject("timestamp", new Date());
        mav.setViewName(viewName);
        return mav;
    }

    public Logger getLogger() {
        return LoggerFactory.getLogger(BaseGlobalExceptionHandler.class);
    }
}
