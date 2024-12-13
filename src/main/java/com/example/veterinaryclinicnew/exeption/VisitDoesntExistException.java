package com.example.veterinaryclinicnew.exeption;

public class VisitDoesntExistException extends RuntimeException {

    public VisitDoesntExistException(String message) {
        super(message);
    }

}
