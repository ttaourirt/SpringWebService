package com.example.JEEWeb;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vehicule {

    private List<Rent> rents = new ArrayList<Rent>();

    private long id;
    private String plateNumber;


    public Vehicule() {
    }
    public Vehicule(String plateNumber) {
        super();
        this.plateNumber = plateNumber;
    }

    @OneToMany(mappedBy="vehicule", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
