package com.parkingSlots.parkingslots.service;

import com.parkingSlots.parkingslots.dto.ParkingSlotDto;
import java.util.List;

public interface IParkingSlot {
	
	 List<ParkingSlotDto> avilableParkingSlot();
	 void parkingAllocate(ParkingSlotDto parkingSlotDto);
	 ParkingSlotDto fetchVehileNumberAllocatedSlot(String vehicle_number);
	 

}
