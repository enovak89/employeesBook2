package com.example.employeesbook2.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
