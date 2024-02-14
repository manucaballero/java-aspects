package tfoc.javaaspectsworkshop.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import tfoc.javaaspectsworkshop.services.AspectsUseCase;
import tfoc.javaaspectsworkshop.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class NoAspectTest {


    @Autowired
    private AspectsController controller;

    @Autowired
    private AspectsUseCase aspectsUseCase;

    @BeforeEach
    void setUp() {

        aspectsUseCase = new AspectsUseCase();
        controller = new AspectsController(aspectsUseCase);
    }

    @Test
    void testAspectForCar() {

        Car car = new Car();
        car.setSeats(1);
        car.setBrand("DACIA");
        Car newCar = controller.changeCar(car);
        assertEquals(car.getSeats(),newCar.getSeats());
    }

}
