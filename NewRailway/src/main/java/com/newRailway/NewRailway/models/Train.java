package com.newRailway.NewRailway.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
@Entity
@Table(name = "Trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private String line;

    @OneToMany(mappedBy = "trainId")
    private Collection<Trip> trainTrips = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @JsonManagedReference(value = "a")
    public Collection<Trip> getTrainTrips() {
        return trainTrips;
    }

    public void setTrainTrips(Collection<Trip> trainTrips) {
        this.trainTrips = trainTrips;
    }
}