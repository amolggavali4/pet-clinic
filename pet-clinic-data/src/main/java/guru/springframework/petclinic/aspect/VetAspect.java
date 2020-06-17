package guru.springframework.petclinic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class VetAspect {

    @Pointcut("execution(* guru.springframework.petclinic.repositories.VetRepository.*(..))")
    public void logAll(){}
}
