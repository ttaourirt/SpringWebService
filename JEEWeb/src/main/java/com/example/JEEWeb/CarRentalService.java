package com.example.JEEWeb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

@RestController
public class CarRentalService {

    private List<Car> cars = new ArrayList<Car>();

    public CarRentalService() {
        cars.add(new Car("11AA22", "NIO", 110000));
        cars.add(new Car("33BB44", "Tesla", 45222));
        cars.add(new Car("32DD66", "Toyota", 4900));
        cars.add(new Car("77SS88", "Peugeot", 12000));
    }

    @GetMapping("/cars")
    public List<Car> getListOfCars(){
        return cars;
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody Car car) throws Exception{
        System.out.println(car);
        cars.add(car);
    }

    @GetMapping("/cars/{plateNumber}")
    public Car getCar(@PathVariable(value = "plateNumber") String immatriculation){
        System.out.println(immatriculation);
        // parcourir avec une boucle le tableau des voitures à la recherche de la voiture qui a la plaque immatriculation
        for(Car car: cars){
            if(car.getPlateNumber().equals(immatriculation)){
                return car;
            }
        }
        return null;
    }

    @GetMapping("/cars/{brand}")
    public Car getCar(@PathVariable(value = "brand") String marque){
        for(Car car: cars){
            if(car.getBrand().equals(marque)){
                return car;
            }
        }
        return null;
    }


}