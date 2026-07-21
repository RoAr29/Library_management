package com.library.management.exception;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(
	        MethodArgumentNotValidException ex) {

	    Map<String, String> errors = new HashMap<>();

	    for(FieldError error : ex.getBindingResult().getFieldErrors()){

	        errors.put(
	                error.getField(),
	                error.getDefaultMessage()
	        );

	    }

	    return new ResponseEntity<>(
	            errors,
	            HttpStatus.BAD_REQUEST
	    );

	}

    }