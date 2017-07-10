package com.hjj.ben.utils;

import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ben on 7/10/17.
 */
public class Ajax {

    public static boolean isAjax(HttpServletRequest request) {
        String requestWith = request.getHeader("X-Requested-With");
        return requestWith != null && "XMLHttpRequest".equals(requestWith);
    }

}
