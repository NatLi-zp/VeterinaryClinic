package com.example.veterinaryclinicnew.exeption;

public class PetDoesntExistException extends RuntimeException {

    public PetDoesntExistException(String message) {
        super(message);
    }

}
