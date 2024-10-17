package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    public final List<Car> carsList = new ArrayList<>();

    public CarServiceImpl() {
        carsList.add(new Car("PRIORA", 2008, 203));
        carsList.add(new Car("GRANTA", 2012, 322));
        carsList.add(new Car("KALINA", 2016, 799));
        carsList.add(new Car("X-RAY", 2018, 747));
        carsList.add(new Car("VESTA", 2020, 321));
    }

    public List<Car> getCars(int count) {

        if (count < 0) {
            throw new IllegalArgumentException("Count must be positive.");
        }
        if (count > carsList.size()) {
            return new ArrayList<>(carsList);
        }
        return new ArrayList<>(carsList.subList(0, count));
    }
}
