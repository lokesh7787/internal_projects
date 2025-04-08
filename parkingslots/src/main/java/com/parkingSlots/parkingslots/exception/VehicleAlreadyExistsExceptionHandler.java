package com.parkingSlots.parkingslots.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class VehicleAlreadyExistsExceptionHandler extends RuntimeException {

	public VehicleAlreadyExistsExceptionHandler(String msg) {
		super(msg);
	}

}
