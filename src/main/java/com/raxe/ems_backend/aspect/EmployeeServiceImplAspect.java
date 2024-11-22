package com.raxe.ems_backend.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class EmployeeServiceImplAspect {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImplAspect.class);

    @Before(value="execution(* com.raxe.ems_backend.service.impl.EmployeeServiceImpl.getAllEmployees(..))")
    public void beforeGetAllEmployees(JoinPoint joinPoint) {
        logger.info("Before getAllEmployees() :"+ joinPoint.getSignature());
    }

    @After(value="execution(* com.raxe.ems_backend.service.impl.EmployeeServiceImpl.getAllEmployees(..))")
    public void afterGetAllEmployees(JoinPoint joinPoint) {
        logger.info("After getAllEmployees() :"+ joinPoint.getSignature());
    }

    @Pointcut(value= "execution(* com.raxe.ems_backend.service.impl.EmployeeServiceImpl.getAllEmployees(..))")
    private void logDisplayingAllEmployees()
    {
    }

    //Declares the around advice that is applied before and after the method matching with a pointcut expression
    @Around(value= "logDisplayingAllEmployees()")
    public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable
    {
        logger.info("The method aroundAdvice() before invokation of the method " + jp.getSignature().getName() + " method");
        try
        {
            jp.proceed();
        }
        finally
        {

        }
        logger.info("The method aroundAdvice() after invokation of the method " + jp.getSignature().getName() + " method");

    }

}
