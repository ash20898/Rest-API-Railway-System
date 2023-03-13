package com.newRailway.NewRailway.repository;

import com.newRailway.NewRailway.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip,Integer> {

}
