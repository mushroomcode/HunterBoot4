package com.example.Aspects;

import com.example.annotations.HunterLogAnno;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 使用 Aspect 实现注解
 */
@Component
@Aspect
public class HunterAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.example.annotations.HunterLogAnno) && execution(public * com.example.Controller..*(*))")
    private void logPointCut() { }

    @Pointcut("execution(public * com.example.Services..*(*))")
    private void normalPointCut() {
        System.out.println("pointCut");
    }

    /** 将Services 文件下，且带有 HunterLogAnnotation 的类进行
     *
     * @param joinPoint
     */
    @Around("normalPointCut() && @annotation(com.example.annotations.HunterLogAnno)")
    private void normalPointBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("===========================");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 执行具体的方法，在使用 Around 类的时候，需要对执行方法进行调用，否则只会执行 Around 方法 normalPointBefore 里面的逻辑
        joinPoint.proceed();
        // 注解解析
        HunterLogAnno hunterLogAnno = method.getAnnotation(HunterLogAnno.class);
        String value = hunterLogAnno.value();
        // 打印注解记录
        logger.info(value);
        logger.info("===========================");
    }


}
