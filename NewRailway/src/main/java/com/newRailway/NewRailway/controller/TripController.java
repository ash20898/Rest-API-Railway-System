package com.newRailway.NewRailway.controller;

import com.newRailway.NewRailway.models.Trip;
import com.newRailway.NewRailway.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping(value = "/Trips")
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip)
    {
        tripService.addTrip(trip);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/Trips")
    public List<Trip> getAllTrips(){
        return  tripService.getAllTrips();
    }
    @GetMapping("/Trips/{id}")
    public Trip getTripById(@PathVariable int id){
        return  tripService.getTripById(id);
    }
    @DeleteMapping("Trips/{id}")
    public Trip deleteTripById(@PathVariable int id){
        return tripService.deleteTripById(id);
    }
    @PutMapping("Trips/{id}")
    public Trip updateTripById(@PathVariable int id, @RequestBody Trip trip)
    {
        return  tripService.updateTripById(id,trip);
    }
}
