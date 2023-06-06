package tn.esprit.faroukboussaid.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    //@Before("execution( * tn.esprit.faroukboussaid.Services.*.* (..))")
    //public void inMethod(JoinPoint joinPoint){
       // log.info("in method : " + joinPoint.getSignature().getName());
    //}
    @After("execution( * tn.esprit.faroukboussaid.Services.*.add* (..))")
    public void outMethod(JoinPoint joinPoint){
        log.info("methode executé : " + joinPoint.getSignature().getName());

    }
}
