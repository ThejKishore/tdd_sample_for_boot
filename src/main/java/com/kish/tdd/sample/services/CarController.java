package com.kish.tdd.sample.services;


import com.kish.tdd.sample.businesslogic.CarService;
import com.kish.tdd.sample.pojo.Car;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {


    CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{carname}")
    public Car getCar(@PathVariable String carname){
        return carService.getCarDetails(carname);

    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException(){

    }
}
