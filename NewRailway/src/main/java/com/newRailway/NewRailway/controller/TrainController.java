package com.newRailway.NewRailway.controller;

import com.newRailway.NewRailway.models.Train;
import com.newRailway.NewRailway.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainController {
    @Autowired
    private TrainService trainService;

    @PostMapping("/Trains")
    public ResponseEntity<Train> saveTrain(@RequestBody Train train){
        trainService.saveTrain(train);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/Trains")
    public List<Train> getAllTrains(){
        return  trainService.getAllTrains();
    }
    @GetMapping("/Trains/{id}")
    public Train getTrainById(@PathVariable("id") int id){
        return  trainService.getTrainById(id);
    }
    @DeleteMapping("/Trains/{id}")
    public Train deleteTrainById(@PathVariable("id") int id){
        return trainService.deleteTrainById(id);
    }
    @PutMapping("/Trains/{id}")
    public Train updateTrain(@PathVariable int id,@RequestBody Train train){
        return trainService.updateTrain(id,train);
    }
    @GetMapping("/Trains/{trainId}/{tripId}")
    public Train assignTripToTrain(@PathVariable int trainId, @PathVariable int tripId){
        return  trainService.assignTripToTrain(trainId,tripId);
    }
}
