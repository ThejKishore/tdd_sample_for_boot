package com.kish.tdd.sample.businesslogic;


import com.kish.tdd.sample.jpa.CarRepository;
import com.kish.tdd.sample.pojo.Car;
import org.springframework.stereotype.Service;

@Service
public class CarService {


    private CarRepository carRepository;


    public CarService (CarRepository carRepository){
        this.carRepository = carRepository;
    }


    public Car getCarDetails(String name){
        return carRepository.findByName(name);
    }

}
