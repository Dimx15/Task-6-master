package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class CarService {
    private List<Car> cars = Arrays.asList(
            new Car("Toyota", "White", 887),
            new Car("Lada", "Black", 666),
            new Car("BMW", "Green", 238),
            new Car("Haval", "Red", 444)
    );

        public List<Car> getCars(int count) {
        if (count > cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
