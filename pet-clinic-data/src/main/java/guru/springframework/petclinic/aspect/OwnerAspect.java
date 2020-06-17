package guru.springframework.petclinic.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Slf4j
@Component
public class OwnerAspect {

    @Pointcut("execution(* org.springframework.data.jpa.repository.JpaRepository.save(..))")
    public void logSaveBefore(){}

    @Pointcut("execution(* guru.springframework.petclinic.services.jpa.OwnerJPAService.*(..))")
    public void logOwnerService(){}




}
