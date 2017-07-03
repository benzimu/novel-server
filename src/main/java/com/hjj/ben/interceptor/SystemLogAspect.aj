package com.hjj.ben.interceptor;

import com.hjj.ben.annotation.SystemControllerLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 日志管理切点类
 * Created by ben on 7/3/17.
 */
@Aspect
@Component
public class SystemLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    /**
     * controller切入点
     */
    @Pointcut("@annotation(com.hjj.ben.annotation.SystemControllerLog)")
    public void controllerAspect() {
        logger.info("#####controllerAspect#####");
    }

    /**
     * 前置通知 用于拦截controller层操作
     * @param joinPoint 切点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("#####controllerAspect()#####");
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).
                getRequest();
        try {
            // 请求uri
            String uri = request.getRequestURI();
            // 请求方法类型
            String method_type = request.getMethod();
            // 请求方法
            String method = joinPoint.getTarget().getClass().getName() + "." +
                    joinPoint.getSignature().getName() + "()" ;
            // 方法描述
            String description = getControllerMethodDescription(joinPoint);
            Object [] objs = {uri, method_type, method, description};
            logger.info("{} {} {} {}", objs);
        } catch (Exception e) {
            // 记录异常日志
            logger.error("#####前置通知异常，异常信息：{}#####", e);
        }
    }

    /**
     * 获取注解中对方法的描述
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        // 获取目标类名
        String targetName = joinPoint.getTarget().getClass().getName();
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取参数
        Object[] args = joinPoint.getArgs();
        // 生成类对象
        Class targetClass = Class.forName(targetName);
        // 获取该类中的方法
        Method[] methods = targetClass.getMethods();

        String description = "";
        for (Method method : methods) {
            // 判断是否为切入点方法（方法名与参数个数都相同）
            if (!method.getName().equals(methodName)) {
                continue;
            }
            Class[] clazzs = method.getParameterTypes();
            if (clazzs.length != args.length) {
                continue;
            }
            description = method.getAnnotation(SystemControllerLog.class).description();
        }
        return description;
    }
}

