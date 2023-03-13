package com.newRailway.NewRailway.service;

import com.newRailway.NewRailway.models.Trip;
import com.newRailway.NewRailway.models.User;
import com.newRailway.NewRailway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  TripService tripService;

    public void saveUser(User user){
        userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(int id){
        return  userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User with UserId : " + id + " couldn't be found") );
    }
    public User deleteUserById(int id){
        User user = getUserById(id);
        userRepository.deleteById(id);
        return user;
    }
    public User updateUser(int id , User user)
    {
        User exUser = getUserById(id);
        exUser.setUserName(user.getUserName());
        exUser.setAge(user.getAge());
        exUser.setUserTrips(user.getUserTrips());
        userRepository.save(exUser);
        return exUser;
    }

    public User assignTripToUser(int userId, int tripId) {
        User user = getUserById(userId);
        Trip trip = tripService.getTripById(tripId);
        Collection<Trip> userTrips = user.getUserTrips();
        userTrips.add(trip);
        userRepository.save(user);
        tripService.addTrip(trip);
        return  user;
    }
}
