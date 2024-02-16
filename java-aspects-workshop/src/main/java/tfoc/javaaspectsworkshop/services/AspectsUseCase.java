package tfoc.javaaspectsworkshop.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tfoc.javaaspectsworkshop.aspects.AfterOperation;
import tfoc.javaaspectsworkshop.aspects.BeforeOperation;
import tfoc.javaaspectsworkshop.domain.Car;
import tfoc.javaaspectsworkshop.domain.Moto;

@RequiredArgsConstructor
@Service
@Slf4j
public class AspectsUseCase {


    @BeforeOperation
    @AfterOperation
    public Car workingWithCar(Car car){
        log.info("2. starting aspectsUseCase.workingWithCar(), seats value: " + car.getSeats());

        log.info("3. ending aspectsUseCase.workingWithCar(), seats value: " + car.getSeats());
        return car;
    }

    @BeforeOperation
    @AfterOperation
    public Moto workingWithMoto(Moto moto){
        log.info("2. starting aspectsUseCase.workingWithMoto(), color value: " + moto.getColor());

        log.info("3. ending aspectsUseCase.workingWithMoto(), color value: " + moto.getColor());
        return moto;
    }

    public Moto pointcutWithMoto(Moto moto){
        log.info("2. starting aspectsUseCase.pointcutWithMoto(), color value: " + moto.getColor());

        log.info("3. ending aspectsUseCase.pointcutWithMoto(), color value: " + moto.getColor());
        return moto;
    }
}
