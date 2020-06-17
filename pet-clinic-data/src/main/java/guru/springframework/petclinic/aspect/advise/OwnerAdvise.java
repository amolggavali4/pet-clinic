package guru.springframework.petclinic.aspect.advise;

import guru.springframework.petclinic.aspect.OwnerAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class OwnerAdvise extends OwnerAspect {

    @Before("logSaveBefore()")
    public void beforeAdvise(JoinPoint joinPoint){
        Object obj  = joinPoint.getArgs()[0];
        log.info("Saving bean..."+ obj.getClass().getName());
    }

    @Before("logOwnerService()")
    public void beforeAdviceLogOwnerService(JoinPoint jp){
        Object obj = null;
        if(jp.getArgs().length > 0){
            obj = jp.getArgs()[0];
        }
        String className = jp.getTarget().getClass().getName();
        //System.out.println("Acting on "+ jp.getTarget().getClass().getName().substring(className.lastIndexOf('.'))+ " "+jp.getSignature().getName());
        log.info("Acting on "+ jp.getTarget().getClass().getName().substring(className.lastIndexOf('.')+1)+ " "+jp.getSignature().getName());
    }
}
