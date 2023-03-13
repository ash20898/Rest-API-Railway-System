package com.newRailway.NewRailway.controller;

import com.newRailway.NewRailway.models.User;
import com.newRailway.NewRailway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/Users")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/Users")
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }
    @GetMapping("/Users/{id}")
    public User getUserById(@PathVariable("id") int id){
        return  userService.getUserById(id);
    }
    @DeleteMapping("/Users/{id}")
    public User deleteUserById(@PathVariable("id") int id){
         return userService.deleteUserById(id);
    }
    @PutMapping("/Users/{id}")
    public  User updateUser(@PathVariable int id,@RequestBody User user){
       return userService.updateUser(id,user);
    }
    @GetMapping("/Users/{userId}/{tripId}")
    public  User assignTripToUser(@PathVariable int userId, @PathVariable int tripId){
        return userService.assignTripToUser(userId,tripId);
    }

}