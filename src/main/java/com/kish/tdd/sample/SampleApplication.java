package com.kish.tdd.sample;

import com.kish.tdd.sample.jpa.CarRepository;
import com.kish.tdd.sample.pojo.Car;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(CarRepository carRepository){
		return (args)->{
			carRepository.save(Car.builder().name("prius").type("toyota").build());
		};
	}
}
