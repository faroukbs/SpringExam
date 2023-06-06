package tn.esprit.faroukboussaid.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;

@Slf4j
@Component
@Aspect
public class performanceAspect {
    @Around("execution( * tn.esprit.faroukboussaid.Services.*.add*(..))")
    public Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
       Object o =  proceedingJoinPoint.proceed();
       stopWatch.stop();
       log.info("executionTime of {} is {}", proceedingJoinPoint.getSignature().getName(),
               stopWatch.getTotalTimeMillis());
        return o;
    }

    //@Around("execution( * tn.esprit.farouk.skistation.Services.InscriptionServiceImpl.retrieveAllInscription(..))")
    //public List<Object> executionTime2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
      //  List<Object> o = (List<Object>) proceedingJoinPoint.proceed();
       // return o;
    //}

}
