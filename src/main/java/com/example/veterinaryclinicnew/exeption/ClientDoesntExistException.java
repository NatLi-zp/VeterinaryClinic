package com.example.veterinaryclinicnew.exeption;

public class ClientDoesntExistException extends RuntimeException {

    public ClientDoesntExistException(String message) {
        super(message);
    }

}
