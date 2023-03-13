package com.newRailway.NewRailway.repository;

import com.newRailway.NewRailway.models.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train,Integer> {
}
