package com.parkingSlots.parkingslots.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.parkingSlots.parkingslots.dto.ParkingSlotDto;
import com.parkingSlots.parkingslots.entity.ParkingSlotEntity;
import com.parkingSlots.parkingslots.exception.VehicleAlreadyExistsExceptionHandler;
import com.parkingSlots.parkingslots.exception.VehicleNotFoundExceptionHandler;
import com.parkingSlots.parkingslots.mapper.ParkingSlotMapper;
import com.parkingSlots.parkingslots.repository.ParkingSlotsRepository;
import com.parkingSlots.parkingslots.service.IParkingSlot;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParkingSlotImpl implements IParkingSlot {
	
	private ParkingSlotsRepository parkingSlotsRepository;

//	@Override
	public List<ParkingSlotDto> avilableParkingSlot() {
		List<ParkingSlotEntity> parkingSlots =  parkingSlotsRepository.findAll();	
		List<ParkingSlotDto> parkingSlotsDto = getAvailbeFloorDetails(parkingSlots);
		return parkingSlotsDto;
	}

	@Override
	public void parkingAllocate(ParkingSlotDto parkingSlotDto) {
		ParkingSlotEntity parkingSlots = ParkingSlotMapper.mapToParkingSlotEntity(parkingSlotDto, new ParkingSlotEntity());
		boolean isAllReadyExists = parkingSlotsRepository.existsByVechicleNumberOrFloorAndSlotNumber(
				parkingSlotDto.getVechicleNumber(),parkingSlotDto.getFloor(),parkingSlotDto.getSlotNumber());
		if(isAllReadyExists) {
			throw new VehicleAlreadyExistsExceptionHandler(
					"Vehicle Already Exists in parking slot "+ parkingSlotDto.getSlotNumber() + " floor " + parkingSlotDto.getFloor()
		   );
	  }
		
		parkingSlotsRepository.save(parkingSlots);
	}

//	@Override
	public ParkingSlotDto fetchVehileNumberAllocatedSlot(String vechicleNumber) {
		ParkingSlotEntity parkingSlotEnt= parkingSlotsRepository.findByVechicleNumber(vechicleNumber).orElseThrow(
				() -> new VehicleNotFoundExceptionHandler("given Vehiclenumber not found")
				);
		ParkingSlotDto parkingSlotDto = ParkingSlotMapper.mapToParkingSlotDto(parkingSlotEnt, new ParkingSlotDto());
		parkingSlotDto.setOcuppied(true);
		return parkingSlotDto;
	}
	
	private List<ParkingSlotDto> getAvailbeFloorDetails(List<ParkingSlotEntity> parkingSlots){
		List<ParkingSlotDto> floors = getAllFloorDetails();
		
		for(ParkingSlotEntity parkingSlotEntity: parkingSlots) {
			for(ParkingSlotDto curr : floors) {
				if(curr.getFloor().equals(parkingSlotEntity.getFloor()) &&
					    parkingSlotEntity.getSlotNumber() == curr.getSlotNumber()) {
					System.out.println("Comparing -> Floor: " + curr.getFloor() + " == " + parkingSlotEntity.getFloor() +
	                        ", Slot: " + curr.getSlotNumber() + " == " + parkingSlotEntity.getSlotNumber());
					curr.setOcuppied(true);
				}
			}
		}
		
		
		return floors.stream().filter(slot -> !slot.isOcuppied()).collect(Collectors.toList());
	}
	private List<ParkingSlotDto> getAllFloorDetails(){
		List<ParkingSlotDto> floors = new ArrayList<>();
		
		for(int i = 1;i<=2;i++) {
			for(int j = 1; j<=5;j++) {
				floors.add(new ParkingSlotDto("","B"+i,j,null,null,false));
			}
		}
		
		return floors;
	}

}
