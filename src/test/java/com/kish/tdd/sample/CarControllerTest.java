package com.kish.tdd.sample;


import com.kish.tdd.sample.businesslogic.CarService;
import com.kish.tdd.sample.pojo.Car;
import com.kish.tdd.sample.services.CarController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {


    @Autowired
    MockMvc mockMvc;


    @MockBean
    CarService carService;


    @Test
    public void getcar_ShouldReturnCar() throws Exception
    {
        //Mocking the carService object with @MockBean
        //And returning the mock value
        given(carService.getCarDetails("prius")).willReturn(Car.builder().name("prius").type("toyota").build());


        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("name").value("prius"))
        .andExpect(jsonPath("type").value("toyota"));

    }



}
