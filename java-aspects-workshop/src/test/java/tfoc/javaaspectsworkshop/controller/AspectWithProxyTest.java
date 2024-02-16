package tfoc.javaaspectsworkshop.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tfoc.javaaspectsworkshop.aspects.WorkShopAspect;
import tfoc.javaaspectsworkshop.domain.Moto;
import tfoc.javaaspectsworkshop.services.AspectsUseCase;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class AspectWithProxyTest {

    private AspectsUseCase aspectsUseCase;

    @BeforeEach
    public void setUp(){

        /*
        Creamos un proxy para el use case que queremos testear y le añadimos el aspecto. Así cuando llamemos al método pointcutWithMoto el advice puede saltar
         */
        WorkShopAspect workShopAspect = new WorkShopAspect();
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(new AspectsUseCase());
        aspectJProxyFactory.addAspect(workShopAspect);

        aspectsUseCase = aspectJProxyFactory.getProxy();
    }

    @Test
    void pointcutWithMotoAssertAspectIsWorking(){

        Moto result = aspectsUseCase.pointcutWithMoto(Moto.builder()
                        .brand("Ducati")
                        .color("Red")
                .build());

        assertEquals("Red",result.getColor());
        assertEquals("AM",result.getBrand());
    }
}
