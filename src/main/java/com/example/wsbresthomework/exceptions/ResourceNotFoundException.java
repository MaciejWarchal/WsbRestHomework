package com.example.wsbresthomework.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Nie znaleziono zasobu");
    }
}
