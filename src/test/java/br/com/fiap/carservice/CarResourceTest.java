package br.com.fiap.carservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarResourceTest {

    @Autowired
    private CarResource carResource;

    @Test
    public void shouldFindCarByColor(){
        //Stubs
        String color = "Cinza";
        String modelo = "Civic";

        Car car = new Car();
        car.setColor(color);
        car.setModel(modelo);

        carResource.save(car);

        List<Car> cars = carResource.findCarByColor(color);

        assertEquals(cars.get(0).getColor(), color);
        assertEquals(cars.get(0).getModel(), modelo);
    }
}
