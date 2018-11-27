package com.example.lukehxh.demo.exceptions;

public class PersonNotFound {

    private String errorMessage;

    public PersonNotFound() {
        this("Couldn't find any person!");
    }

    public PersonNotFound(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
