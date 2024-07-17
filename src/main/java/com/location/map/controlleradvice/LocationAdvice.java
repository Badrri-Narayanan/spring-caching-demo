package com.location.map.controlleradvice;

import com.location.map.exception.CountryNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LocationAdvice {

    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<String> handleException(CountryNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
