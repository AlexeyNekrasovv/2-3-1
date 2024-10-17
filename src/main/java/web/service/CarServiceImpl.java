package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    public final List<Car> carsList = new ArrayList<>();

    // Инициализация списка
    public CarServiceImpl() {
        carsList.add(new Car("BMW 3 Series", 1980, 241223));
        carsList.add(new Car("Chevrolet Corvette", 2000, 123456));
        carsList.add(new Car("Toyota Camry", 2006, 444444));
        carsList.add(new Car("Ford Mustang", 1999, 880555));
        carsList.add(new Car("Tesla Model S", 2015, 321000));
    }

    // Получение подсписка автомобилей
    public List<Car> getCars(int count) {
        // Проверяем границы, чтобы избежать IndexOutOfBoundsException
        if (count < 0) {
            throw new IllegalArgumentException("Count must be positive.");
        }
        if (count > carsList.size()) {
            return new ArrayList<>(carsList); // Возвращаем полный список в случае, если count больше размера списка
        }
        return new ArrayList<>(carsList.subList(0, count)); // Возвращаем подсписок
    }
}
