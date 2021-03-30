package com.example.JEEWeb;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicule{

    private int numberOfSeats;


    public Car() {
        super();
    }

    public Car(String platenumber, String brand, int price,int numberOfSeats ) {
        super(platenumber, price, brand);
        this.numberOfSeats = numberOfSeats;

    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfSeats='" + numberOfSeats + '\'' +
                '}';
    }
}