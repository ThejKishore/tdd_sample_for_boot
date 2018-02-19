package com.kish.tdd.sample.jpa;


import com.kish.tdd.sample.pojo.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository  extends CrudRepository<Car,Long>{

    Car findByName(String name);

}
