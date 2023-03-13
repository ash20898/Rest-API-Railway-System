package com.newRailway.NewRailway.service;

import com.newRailway.NewRailway.models.Trip;
import com.newRailway.NewRailway.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public void addTrip(Trip trip){
        tripRepository.save(trip);
    }
    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }
    public Trip getTripById(int id){
        return tripRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Trip of tripId : " + id + " couldn't been found"));
    }
    public Trip deleteTripById(int id){
        Trip trip = getTripById(id);
        tripRepository.deleteById(id);
        return trip;
    }
    public Trip updateTripById(int id , Trip trip){
        Trip exTrip = getTripById(id);
        exTrip.setSource(trip.getSource());
        exTrip.setDestination(trip.getDestination());
        exTrip.setPrice(trip.getPrice());
        exTrip.setTrainId(trip.getTrainId());
        exTrip.setTripUsers(trip.getTripUsers());
        addTrip(exTrip);
        return exTrip;
    }

}
