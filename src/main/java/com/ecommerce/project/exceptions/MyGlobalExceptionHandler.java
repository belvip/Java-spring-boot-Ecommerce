// Package declaration for exception handling in the e-commerce project
package com.ecommerce.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// @RestControllerAdvice indicates that this class provides centralized exception handling
@RestControllerAdvice
public class MyGlobalExceptionHandler {

    // This method handles validation errors, specifically for invalid method arguments
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> myMethodArgumentNotValidException(MethodArgumentNotValidException e){
        // Creating a map to store field names and corresponding validation error messages
        Map<String, String> response = new HashMap<>();

        // Looping through all validation errors
        e.getBindingResult().getAllErrors().forEach(err -> {
            // Extracting field name and error message
            String fieldName = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            response.put(fieldName, message); // Adding the field and message to the response map
        });

        // Returning a BAD_REQUEST (400) response with validation error messages
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
    }

    // This method handles exceptions when a requested resource is not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> myResourceNotFoundException(ResourceNotFoundException e){
        String message = e.getMessage(); // Retrieving error message from exception

        // Returning a NOT_FOUND (404) response with the exception message
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<String> myAPIException(APIException e){
        String message = e.getMessage(); // Retrieving error message from exception

        // Returning a NOT_FOUND (404) response with the exception message
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
