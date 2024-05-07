package com.project.ecommerce.Aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthControllerAspect {

    private final Logger logger = LoggerFactory.getLogger(AuthControllerAspect.class);

    @Pointcut("execution(* com.project.ecommerce.controllers.AuthController.*(..))")
    public void authControllerMethods() {
    }

    @AfterReturning(pointcut = "authControllerMethods()", returning = "result")
    public void logMethodCall(Object result) {
        logger.info("Method executed successfully. Result: {}", result);
    }
}

