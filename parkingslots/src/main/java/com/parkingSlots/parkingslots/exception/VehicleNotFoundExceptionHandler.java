package com.parkingSlots.parkingslots.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VehicleNotFoundExceptionHandler  extends RuntimeException {
	
	public VehicleNotFoundExceptionHandler(String msg) {
		super(msg);
	}

}
