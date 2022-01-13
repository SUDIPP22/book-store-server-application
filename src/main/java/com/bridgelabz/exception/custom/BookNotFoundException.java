package com.bridgelabz.exception.custom;

public class BookNotFoundException extends BookStoreCustomException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
