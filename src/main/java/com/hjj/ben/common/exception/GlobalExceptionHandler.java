package com.hjj.ben.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ben on 7/10/17.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BaseGlobalExceptionHandler {
    // 404
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ModelAndView handle404Error(HttpServletRequest req,
                                       HttpServletResponse res,
                                       Exception e) throws Exception {
        getLogger().info("-----handle404Error()-----");
        return handlerError(req, res, e, "common/error-page", HttpStatus.NOT_FOUND);
    }

    // 500
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleError(HttpServletRequest req,
                                    HttpServletResponse res,
                                    Exception e) throws Exception {
        getLogger().info("-----handleError()-----");
        return handlerError(req, res, e, "common/error-page", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 自定义异常
    @ExceptionHandler({MyCustomException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleCustomError(HttpServletRequest req,
                                          HttpServletResponse res,
                                          Exception e) throws Exception {
        return handlerError(req, res, e, "common/error-page", HttpStatus.NOT_FOUND);
    }

    @Override
    public Logger getLogger() {
        return LoggerFactory.getLogger(GlobalExceptionHandler.class);
    }
}
