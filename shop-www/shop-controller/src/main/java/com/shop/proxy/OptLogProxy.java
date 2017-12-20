package com.shop.proxy;

import com.shop.annotation.OptLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by TW on 2017/11/2.
 */
@Component
@Aspect
public class OptLogProxy {

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(com.shop.annotation.OptLog)")
    public void pointCut() {

    }

    /**
     * 环绕通知
     * @param joinPoint
     */
    @Around(value = "pointCut()&&@annotation(optLog)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint, OptLog optLog) throws Throwable {

        String module = optLog.module();
        String desc = optLog.desc();
        long beforeTime = System.currentTimeMillis();

        // 获取所有参数
        Map<String, String[]> params = request.getParameterMap();

        // 请求方法
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        // 执行
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        long excuteTime = endTime - beforeTime; // 执行时间

       // LoginIdentity loginIdentity = (LoginIdentity)session.getAttribute(Constant.LOGIN_USER_KEY);

        // 保存到数据库 消息队列处理


        return result;
    }
}
