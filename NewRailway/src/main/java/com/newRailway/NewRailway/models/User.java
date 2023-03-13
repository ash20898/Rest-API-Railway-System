package com.newRailway.NewRailway.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String userName;
    private int age;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Bookings" , joinColumns = @JoinColumn(name = "User_Id"),
            inverseJoinColumns = @JoinColumn(name = "Trip_Id") )
    private Collection<Trip> userTrips = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Collection<Trip> getUserTrips() {
        return userTrips;
    }

    public void setUserTrips(Collection<Trip> userTrips) {
        this.userTrips = userTrips;
    }
}
