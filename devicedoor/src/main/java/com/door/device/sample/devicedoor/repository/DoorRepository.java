package com.door.device.sample.devicedoor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.door.device.sample.devicedoor.model.Door;

@Repository
public interface DoorRepository extends JpaRepository<Door, Integer> {

}
