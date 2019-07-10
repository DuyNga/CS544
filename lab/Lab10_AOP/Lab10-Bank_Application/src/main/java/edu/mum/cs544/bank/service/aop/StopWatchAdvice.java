package edu.mum.cs544.bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class StopWatchAdvice {

    @Around("execution(* edu.mum.cs544.bank.service.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) {
        String m = pjp.getSignature().getName();
        Object ret = null;
        try {
            StopWatch sw = new StopWatch();
            sw.start(m);
            ret =pjp.proceed();
            sw.stop();
            long totaltime = sw.getLastTaskTimeMillis();
            System.out.println(String.format("Time to execute %s in %s = %s ms",m, pjp.getTarget(), totaltime));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return ret;
    }
}
