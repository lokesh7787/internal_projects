package com.parkingSlots.parkingslots.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parkingSlots.parkingslots.entity.ParkingSlotEntity;

@Repository
public interface ParkingSlotsRepository extends JpaRepository<ParkingSlotEntity, Long> {

	boolean existsByVechicleNumberOrFloorAndSlotNumber(String vechicleNumber, String floor, int slotNumber);
	Optional<ParkingSlotEntity> findByVechicleNumber(String vechicleNumber);
}
