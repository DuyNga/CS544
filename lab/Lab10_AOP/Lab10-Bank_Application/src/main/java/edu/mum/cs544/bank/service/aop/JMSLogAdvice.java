package edu.mum.cs544.bank.service.aop;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSLogAdvice {
    @Autowired
    private ILogger logger;

    @Before("execution(* edu.mum.cs544.bank.jms.*.*(..))")
    public void logCall(JoinPoint joinpoint) {
        Object[] args = joinpoint.getArgs();
        logger.log(String.format("MESSAGE: %s", args[0]));
    }



    /*@After("execution(* edu.mum.cs544.EmailSender.*(..))")
    public void logAfter(JoinPoint joinpoint) {
        Object[] args = joinpoint.getArgs();
//        logger.warn(String.format("method = %s address = %s message = %s outgoing mail server = %s",
//                joinpoint.getSignature().getName()
//                , args[0], args[1]), joinpoint.getTarget());

        logger.warn(String.format("method = %s address = %s message = %s",
                joinpoint.getSignature().getName()
                , args[0], args[1] + " outgoing mail server = " + joinpoint.getTarget()));
    }*/
}
