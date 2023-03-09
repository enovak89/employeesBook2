package com.example.employeesbook2.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException{

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
