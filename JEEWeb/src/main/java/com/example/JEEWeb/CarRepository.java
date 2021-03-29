package com.example.JEEWeb;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository <Car, Long> {

    List<Car> findByName(String name);
}
