package com.example.Aspects;

import com.example.annotations.HunterAsyncAnno;
import com.example.annotations.HunterLogAnno;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 使用 Aspect 实现注解，别忘记添加 @Component 注解让Aspect注解生效
 */
@Component
@Aspect
public class HunterAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *  这里定义一个PointCut，用于描述满足条件的方法
     */
    @Pointcut("execution(public * com.example.Services..*(*))")
    private void normalPointCut() {
        System.out.println("pointCut");
    }

    /** 将Services 文件下，且带有 HunterLogAnno 注解的类进行
     *
     * @param joinPoint
     */
    @Around("normalPointCut() && @annotation(com.example.annotations.HunterLogAnno)")
    private void normalPointAround(ProceedingJoinPoint joinPoint) throws Throwable {
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

    /**
     *  定义一个注解的切点
     * @param joinPoint
     */
    @Around("normalPointCut() && @annotation(com.example.annotations.HunterAsyncAnno)")
    private void asyncPointAround(ProceedingJoinPoint joinPoint) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            HunterAsyncAnno hunterAsyncAnno = method.getAnnotation(HunterAsyncAnno.class);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        joinPoint.proceed();
                        System.out.println("END TIME：" + System.currentTimeMillis());
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }).start();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


}
