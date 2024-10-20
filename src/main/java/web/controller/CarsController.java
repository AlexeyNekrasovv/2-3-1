package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

@Controller
public class CarsController {

    private final CarServiceImpl carService;

    public CarsController(CarService carService) {
        this.carService = (CarServiceImpl) carService;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", required = false) String count, ModelMap model) {

            try {
                model.addAttribute("cars", carService.getCars(count));
            } catch (NumberFormatException e) {

                model.addAttribute("cars", carService.carsList);
                model.addAttribute("error", "Invalid count format. Showing all cars.");
            }

        return "cars";
    }
}