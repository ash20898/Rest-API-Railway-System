package com.newRailway.NewRailway.service;

import com.newRailway.NewRailway.models.Train;
import com.newRailway.NewRailway.models.Trip;
import com.newRailway.NewRailway.models.User;
import com.newRailway.NewRailway.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private TripService tripService;

    public void saveTrain(Train train){
        trainRepository.save(train);
    }
    public List<Train> getAllTrains(){
        return trainRepository.findAll();
    }
    public Train getTrainById(int id){
        return  trainRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Train with TrainId : " + id + " couldn't be found") );
    }
    public Train deleteTrainById(int id){
        Train train = getTrainById(id);
        trainRepository.deleteById(id);
        return train;
    }
    public Train updateTrain(int id , Train train)
    {
        Train ExTrain = getTrainById(id);
        ExTrain.setNumber(train.getNumber());
        ExTrain.setLine(train.getLine());
        ExTrain.setTrainTrips(train.getTrainTrips());
        trainRepository.save(ExTrain);
        return ExTrain;
    }

    public Train assignTripToTrain(int trainId, int tripId) {
        Train train = getTrainById(trainId);
        Trip trip = tripService.getTripById(tripId);
        trip.setTrainId(train);
        Collection<Trip> trainTrips = train.getTrainTrips();
        trainTrips.add(trip);
        tripService.addTrip(trip);
        saveTrain(train);
        return train;
    }
}
