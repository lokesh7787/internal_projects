package com.parkingSlots.parkingslots.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSlotDto {
	
	private String vechicleNumber;
	private String floor;
	private int slotNumber;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private boolean isOcuppied;
	

}
