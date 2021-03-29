package com.example.JEEWeb;

import javax.persistence.Entity;

@Entity
public class Van extends Vehicule{

    private int maxWeight;

    public Van() {
    }

    public Van(int maxWeight) {
        super();
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "Van{" +
                ", maxWeight=" + maxWeight +
                '}';
    }
}
