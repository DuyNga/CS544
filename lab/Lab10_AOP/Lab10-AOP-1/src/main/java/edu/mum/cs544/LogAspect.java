package edu.mum.cs544;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private static Logger logger = LogManager.getLogger(LogAspect.class.getName());

    // indicate any return type
    //any method name
    //any parameters
//	@Before("execution(* *(..))")
//	public void logBefore(JoinPoint joinpoint) {
//		logger.warn("About to exec: " + joinpoint.getSignature().getName());
//	}

    @After("execution(* edu.mum.cs544.EmailSender.*(..))")
    public void logAfter(JoinPoint joinpoint) {
        Object
        logger.warn("method = " + joinpoint.getSignature().getName());
    }

    //	@Before("execution(* *(..))")
//	public void logTargetBefore(JoinPoint joinpoint) {
//		logger.warn("About to exec a method on: " + joinpoint.getTarget());
//	}
//	@After("execution(* *(..))")
    public void logTargetAfter(JoinPoint joinpoint) {
        logger.warn("Just execed a method on: " + joinpoint.getTarget());
    }

}
