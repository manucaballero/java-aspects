package tfoc.javaaspectsworkshop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import tfoc.javaaspectsworkshop.domain.Car;

@Aspect
@Component
@Slf4j
public class WorkShopAspect {


    @Before(value = "@annotation(tfoc.javaaspectsworkshop.aspects.BeforeOperation)")
    public void beforeMethodCall(JoinPoint joinPoint){
        log.info("starting beforeMethodCall advice ");
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof Car) {
                log.info("setting seats to 2 ");
                ((Car) arg).setSeats(2);
            }
        }
    }

    @After(value = "@annotation(tfoc.javaaspectsworkshop.aspects.AfterOperation)")
    public void afterMethodCall(JoinPoint joinPoint){

        log.info("starting afterMethodCall advice");
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof Car) {
                log.info("setting brand to aston martin ");
                ((Car) arg).setBrand("AM");
            }
        }

        log.info("joinPoint.getKind(): " + joinPoint.getKind());
        log.info("joinPoint.getSignature(): " + joinPoint.getSignature().toString());
        log.info("joinPoint.getSourceLocation().getWithinType().getName(): " + joinPoint.getSourceLocation().getWithinType().getName());
    }
}
