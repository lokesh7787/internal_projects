package com.parkingSlots.parkingslots.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.parkingSlots.parkingslots.constant.ParkingSlotsConstant;
import com.parkingSlots.parkingslots.dto.ParkingSlotDto;
import com.parkingSlots.parkingslots.dto.ResponseDto;
import com.parkingSlots.parkingslots.service.IParkingSlot;
//import com.sun.tools.javac.util.List;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class parkingSlotController {
	 
	private IParkingSlot iParkingSlot;
	
	@GetMapping("/availableSlot")
	public ResponseEntity<List<ParkingSlotDto>> avilableParkingSlot() {
		List<ParkingSlotDto> parkingSlots=iParkingSlot.avilableParkingSlot();
		return ResponseEntity.status(HttpStatus.OK).body(parkingSlots);
	}
	
	@PostMapping("/parkingAllocate")
	public ResponseEntity<ResponseDto> parkingAllocate(@RequestBody ParkingSlotDto parkingSlotDto ){
		iParkingSlot.parkingAllocate(parkingSlotDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(ParkingSlotsConstant.STATUS_201,ParkingSlotsConstant.MESSAGE_201));
		
	}
	
	@GetMapping("/parking")
	public ResponseEntity<ParkingSlotDto> fetchVehileNumberAllocatedSlot(@RequestParam String vehicle_number){
		ParkingSlotDto parkingSlotDto = iParkingSlot.fetchVehileNumberAllocatedSlot(vehicle_number);
		return ResponseEntity.status(HttpStatus.OK).body(parkingSlotDto);
	}
}
