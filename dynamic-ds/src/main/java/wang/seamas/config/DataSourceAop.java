package wang.seamas.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class DataSourceAop {

    @Around("execution(* wang.seamas.service.impl.SlaveUserServiceImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        Object result = null;
        try{
            DataSourceManager.set(DataTypes.SLAVE);
            log.info("aop方法{}进行切换数据源", name);
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        }
        finally {
            DataSourceManager.reset();
            log.info("aop方法{}进行重置数据源", name);
        }
        return result;
    }
}
