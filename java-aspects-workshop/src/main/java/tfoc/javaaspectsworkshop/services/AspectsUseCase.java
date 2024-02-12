package tfoc.javaaspectsworkshop.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tfoc.javaaspectsworkshop.aspects.AfterOperation;
import tfoc.javaaspectsworkshop.aspects.BeforeOperation;
import tfoc.javaaspectsworkshop.domain.Car;

@RequiredArgsConstructor
@Service
@Slf4j
public class AspectsUseCase {


    @BeforeOperation
    @AfterOperation
    public Car workingWithAspects(Car car){
        log.info("2. starting aspectsUseCase.workingWithAspects(), seats value: " + car.getSeats());

        log.info("3. ending aspectsUseCase.workingWithAspects(), seats value: " + car.getSeats());
        return car;
    }
}
