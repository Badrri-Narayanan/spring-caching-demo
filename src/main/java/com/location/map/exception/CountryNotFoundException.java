package com.location.map.exception;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException(final String message) {
        super(message);
    }
}
