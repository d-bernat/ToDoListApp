package de.itbernat.springmvc.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ServiceAudit
{
    //@Around("execution(* de.itbernat.springmvc.service.*.*(..))")
    @Around("execution(* @org.springframework.stereotype.Service *.*(..))")
    public Object auditMethod(ProceedingJoinPoint jp) throws Throwable
    {
        String methodName = jp.getSignature().getName();
        log.info("Call to " + methodName);
        Object obj = jp.proceed();
        log.info("Method called successfully: " + methodName);
        return obj;
    }
}
