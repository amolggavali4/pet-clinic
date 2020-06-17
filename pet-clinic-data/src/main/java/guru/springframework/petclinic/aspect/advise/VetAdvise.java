package guru.springframework.petclinic.aspect.advise;

import guru.springframework.petclinic.aspect.VetAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Slf4j
@Component
public class VetAdvise extends VetAspect {

    @Before("logAll()")
    //@Before("execution(* guru.springframework.petclinic.services.jpa.PetJPAService.*(..))")
    public void logAllAdvise(JoinPoint joinPoint){
        System.out.println("logAllAdvise.............");
        String className = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Calling "+ className.substring(className.lastIndexOf('.')+1) +" "+ joinPoint.getSignature().getName());
        if(args.length > 0){
            StringBuilder sb = new StringBuilder();
            log.info("Method parameters ");
            Arrays.stream(args).forEach(x-> sb.append(x).append(';'));
            log.info(sb.toString());
        }

    }
}
