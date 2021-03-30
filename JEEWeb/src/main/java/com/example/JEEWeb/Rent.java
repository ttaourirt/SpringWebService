package com.example.JEEWeb;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Rent {

    private long id;
    private Date beginRent;
    private Date endRent;
    private Person person;
    private Vehicule vehicule;

    public Rent() throws Exception {
        super();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        beginRent = dateFormat.parse("2018-10-09");
        endRent = dateFormat.parse("2018-10-18");
        System.out.println(beginRent.toString());
        System.out.println(endRent.toString());

    }

    @ManyToOne
    @JsonIgnore
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @ManyToOne
    @JsonIgnore
    public Vehicule getVehicule() {
       return vehicule;
    }
    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBeginRent() {
        return beginRent;
    }

    public void setBeginRent(Date beginRent) {
        this.beginRent = beginRent;
    }

    public Date getEndRent() {
        return endRent;
    }

    public void setEndRent(Date endRent) {
        this.endRent = endRent;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "beginRent=" + beginRent +
                ", endRent=" + endRent +
                '}';
    }
}
