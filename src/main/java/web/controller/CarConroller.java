package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.ResourceBundle;

@Controller
@RequestMapping("/cars")
public class CarConroller {
    private final CarService carService;

    @Autowired
    public CarConroller(CarService carService) {
        this.carService = carService;
    }



    @GetMapping
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null) {
            count = carService.getCars(Integer.MAX_VALUE).size();
        }
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }


}
