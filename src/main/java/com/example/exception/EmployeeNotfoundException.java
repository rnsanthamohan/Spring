package com.example.exception;

public class EmployeeNotfoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmployeeNotfoundException(String message) {
        super(message);
    }
}
