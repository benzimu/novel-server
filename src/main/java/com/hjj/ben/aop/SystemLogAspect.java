package com.hjj.ben.aop;

import com.hjj.ben.annotation.SystemControllerLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     * controller切入点, 拦截所有使用@SystemControllerLog注解的controller
     */
    @Pointcut("@annotation(com.hjj.ben.annotation.SystemControllerLog)")
    public void controllerAspect() {
        logger.info("#####controllerAspect()#####");
    }

    /**
     * 前置通知 用于拦截controller层操作
     * @param joinPoint 切点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).
                getRequest();
        try {
            // 请求uri
            // String uri = request.getRequestURI();
            // url
            String requestURL = request.getRequestURL().toString();
            // 请求方法类型
            String method_type = request.getMethod();
            // 请求方法
            String method = joinPoint.getTarget().getClass().getName() + "." +
                    joinPoint.getSignature().getName() + "()" ;
            // 方法描述
            String description = getControllerMethodDescription(joinPoint);
            Object [] objs = {requestURL, description, method_type, method};

//            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            logger.info("{} {} {} {}", objs);
        } catch (Exception e) {
            // 记录异常日志
            logger.error("#####前置通知异常，异常信息：{}#####", e);
        }
    }

    /**
     * 后置通知 连接点方法执行完成后执行（包括正常完成和异常退出）
     * @param joinPoint
     */
    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        logger.info("------doAfter()------: {}");
    }

    /**
     * 环绕通知 连接点方法执行中执行
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("controllerAspect()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        logger.info("------doAround()------");
        return proceedingJoinPoint.proceed();
    }

    /**
     * 返回后通知 连接点方法正常返回执行（如异常退出则不执行）
     * @param joinPoint
     */
    @AfterReturning("controllerAspect()")
    public void doAfterReturning(JoinPoint joinPoint) {
        logger.info("------doAfterRetruning()------");
    }

    /**
     * 异常通知 连接点方法异常时执行
     * @param joinPoint
     */
    @AfterThrowing(value = "controllerAspect()", throwing = "ex")
    public void doAterThrowing(Throwable ex, JoinPoint joinPoint) {
        logger.info("------doAfterThrowing()------");
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


