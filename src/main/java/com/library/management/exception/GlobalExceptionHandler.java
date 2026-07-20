package com.library.management.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ApiError> handleBookNotFound(BookNotFoundException ex){

	    ApiError error = new ApiError(
	            LocalDateTime.now(),
	            HttpStatus.NOT_FOUND.value(),
	            HttpStatus.NOT_FOUND.getReasonPhrase(),
	            ex.getMessage()
	    );

	    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

    }

}