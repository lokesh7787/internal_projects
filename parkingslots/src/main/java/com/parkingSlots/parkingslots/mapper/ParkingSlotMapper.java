package com.parkingSlots.parkingslots.mapper;

import com.parkingSlots.parkingslots.dto.ParkingSlotDto;
import com.parkingSlots.parkingslots.entity.ParkingSlotEntity;

public class ParkingSlotMapper {
	
	public static ParkingSlotDto mapToParkingSlotDto(ParkingSlotEntity parkingSlotEntity, ParkingSlotDto parkingSlotDto) {
		
		parkingSlotDto.setVechicleNumber(parkingSlotEntity.getVechicleNumber());
		parkingSlotDto.setFloor(parkingSlotEntity.getFloor());
		parkingSlotDto.setSlotNumber(parkingSlotEntity.getSlotNumber());
		parkingSlotDto.setStartTime(parkingSlotEntity.getStartTime());
		parkingSlotDto.setEndTime(parkingSlotEntity.getEndTime());
		return parkingSlotDto;
		
	}
	
	public static ParkingSlotEntity mapToParkingSlotEntity(ParkingSlotDto parkingSlotDto, ParkingSlotEntity parkingSlotEntity) {
			
		parkingSlotEntity.setVechicleNumber(parkingSlotDto.getVechicleNumber());
		parkingSlotEntity.setFloor(parkingSlotDto.getFloor());
		parkingSlotEntity.setSlotNumber(parkingSlotDto.getSlotNumber());
		parkingSlotEntity.setStartTime(parkingSlotDto.getStartTime());
		parkingSlotEntity.setEndTime(parkingSlotDto.getEndTime());
		return parkingSlotEntity;
			
		} 

}
