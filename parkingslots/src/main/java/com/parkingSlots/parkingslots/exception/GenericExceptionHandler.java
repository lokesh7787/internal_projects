package com.parkingSlots.parkingslots.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.parkingSlots.parkingslots.dto.ErrorResponseDto;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(VehicleNotFoundExceptionHandler.class)
	public ResponseEntity<ErrorResponseDto> handlVehicleNotFoundException(VehicleNotFoundExceptionHandler exception,  WebRequest webRequest ){
		
		ErrorResponseDto errorResponeDto = new ErrorResponseDto(
				webRequest.getDescription(false),
				HttpStatus.NOT_FOUND,
				exception.getMessage(),
				LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponeDto,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(VehicleAlreadyExistsExceptionHandler.class)
	public ResponseEntity<ErrorResponseDto> handlVVehicleAlreadyExistsExceptionHandler(VehicleAlreadyExistsExceptionHandler exception,  WebRequest webRequest ){
		
		ErrorResponseDto errorResponeDto = new ErrorResponseDto(
				webRequest.getDescription(false),
				HttpStatus.BAD_REQUEST,
				exception.getMessage(),
				LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponeDto,HttpStatus.BAD_REQUEST);
		
	}

}
