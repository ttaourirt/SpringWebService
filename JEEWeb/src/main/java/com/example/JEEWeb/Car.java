package com.example.JEEWeb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    private String plateNumber;
    private String brand;
    private int price;
    private Integer id;
    long key;

    public Car() {
        super();
    }

    public Car(String plateNumber, String brand, int price) {
        super();
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getKey() {
        return key;
    }
    public void setKey(long key) {
        this.key = key;
    }

}