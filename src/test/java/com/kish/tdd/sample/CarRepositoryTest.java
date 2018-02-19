package com.kish.tdd.sample;

import com.kish.tdd.sample.jpa.CarRepository;
import com.kish.tdd.sample.pojo.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {


    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void getCar_testGetByName(){
        //Adding the data for testing purpose....
        Car savedCar = entityManager.persistFlushFind(Car.builder().name("prius").type("Toyota").build());

        Car retrievedCar = repository.findByName("prius");

        if(savedCar.getType().equals(retrievedCar.getType())){
            System.out.println("data matches");
        }
    }



}

