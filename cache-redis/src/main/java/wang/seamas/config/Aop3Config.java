package wang.seamas.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class Aop3Config implements Ordered {

    @Pointcut("execution(* wang.seamas.service.*.*(..))")
    private void pointCut(){};

    @Around("pointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        try{
            log.info("开始查询3, 方法:{}, 参数:{}", name, args);
            return joinPoint.proceed();
        }finally {
            log.info("结束查询3, 方法:{}, 参数:{}", name, args);
        }
    }

    @Override
    public int getOrder() {
        return 3;
    }
}