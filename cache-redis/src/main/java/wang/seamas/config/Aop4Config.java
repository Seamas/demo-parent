package wang.seamas.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class Aop4Config {

    // AOP的顺序，先是实现Ordered接口或者是使用@Order注解的，后是未实现接口的，
    // 如此例中，先Aop2Config, Aop3Config, CacheConfig, AopConfig
    // 那么对于 CacheConfig，和AopConfig都没有顺序的，如何决定呢，
    // 可能是根据扫描到的顺序来决定

    @Pointcut("execution(* wang.seamas.service.*.*(..))")
    private void pointCut(){};

    @Around("pointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        try{
            log.info("开始查询4, 方法:{}, 参数:{}", name, args);
            return joinPoint.proceed();
        }finally {
            log.info("结束查询4, 方法:{}, 参数:{}", name, args);
        }
    }

}
