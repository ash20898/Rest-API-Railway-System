package com.newRailway.NewRailway.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String source;
    private  String destination;
    private  int price;


    @ManyToOne
    @JoinColumn(name = "Train_Id")
    private Train trainId;

    @JsonIgnore
    @ManyToMany(mappedBy = "userTrips")
    private Collection<User> tripUsers = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @JsonBackReference(value = "a")
    public Train getTrainId() {
        return trainId;
    }

    public void setTrainId(Train trainId) {
        this.trainId = trainId;
    }


    public Collection<User> getTripUsers() {
        return tripUsers;
    }

    public void setTripUsers(Collection<User> tripUsers) {
        this.tripUsers = tripUsers;
    }
}
