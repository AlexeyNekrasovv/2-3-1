package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
public class CarsController {

    private final CarServiceImpl carService;

    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", required = false) String count, ModelMap model) {
        // Добавляем cars в модель вне зависимости от count
        if (count == null || Integer.valueOf(count) > 5) {
            model.addAttribute("cars", carService.carsList);
        } else {
            try {
                int carCount = Integer.valueOf(count);
                model.addAttribute("cars", carService.getCars(carCount));
            } catch (NumberFormatException e) {
                // Обработка ошибки формата числа
                model.addAttribute("cars", carService.carsList);
                model.addAttribute("error", "Invalid count format. Showing all cars.");
            }
        }

        return "cars";
    }
}