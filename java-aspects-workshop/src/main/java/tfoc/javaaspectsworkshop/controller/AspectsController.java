package tfoc.javaaspectsworkshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfoc.javaaspectsworkshop.domain.Car;
import tfoc.javaaspectsworkshop.domain.Moto;
import tfoc.javaaspectsworkshop.services.AspectsUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class AspectsController {

    private final AspectsUseCase aspectsUseCase;
    @PostMapping("/changeCar")
    public Car changeCar(@RequestBody Car car){

        log.info("1. about to call aspectsUseCase.workingWithAspects(), seats value: "
                + car.getSeats() + ", brand value: " + car.getBrand());
        Car response = aspectsUseCase.workingWithCar(car);
        log.info("4. just returned from aspectsUseCase.workingWithAspects(), brand value: " + car.getBrand());

        return response;
    }

    @PostMapping("/changeMoto")
    public Moto changeMoto(@RequestBody Moto moto){

        log.info("1. about to call aspectsUseCase.workingWithMoto(), color value: "
                + moto.getColor() + ", brand value: " + moto.getBrand());
        Moto response = aspectsUseCase.workingWithMoto(moto);
        log.info("4. just returned from aspectsUseCase.workingWithMoto(), brand value: " + moto.getBrand());

        return response;
    }

    @PostMapping("/pointcutMoto")
    public Moto pointcutMoto(@RequestBody Moto moto){

        log.info("1. about to call aspectsUseCase.pointcutWithMoto(), color value: "
                + moto.getColor() + ", brand value: " + moto.getBrand());
        Moto response = aspectsUseCase.pointcutWithMoto(moto);
        log.info("4. just returned from aspectsUseCase.pointcutWithMoto(), brand value: " + moto.getBrand());

        return response;
    }

}
