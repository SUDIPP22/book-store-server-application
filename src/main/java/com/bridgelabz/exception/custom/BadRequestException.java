package com.bridgelabz.exception.custom;

public class BadRequestException extends BookStoreCustomException {
    public BadRequestException(String message) {
        super(message);
    }
}
