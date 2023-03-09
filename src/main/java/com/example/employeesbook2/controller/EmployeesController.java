package com.example.employeesbook2.controller;

import com.example.employeesbook2.employee.Employees;
import com.example.employeesbook2.exceptions.EmployeeAlreadyAddedException;
import com.example.employeesbook2.exceptions.EmployeeNotFoundException;
import com.example.employeesbook2.exceptions.EmployeeStorageIsFullException;
import com.example.employeesbook2.service.EmployeesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    private final EmployeesService employeesService;


    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeeStorageIsFullException.class)
    public String handleException(EmployeeStorageIsFullException e) {
        return "Статус http: " + HttpStatus.BAD_REQUEST.value() + " " + e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
            @ExceptionHandler(EmployeeNotFoundException.class)
            public String handlerException(EmployeeNotFoundException e) {
        return "Статус http: " + HttpStatus.BAD_REQUEST.value() + " " + e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public String handlerException(EmployeeAlreadyAddedException e) {
        return "Статус http: " + HttpStatus.BAD_REQUEST.value() + " " + e.getMessage();
    }

    EmployeesService emplService = new EmployeesService();

    @GetMapping("/add")
    public Employees addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return emplService.addEmpl(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employees removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return emplService.removeEmpl(firstName, lastName);
    }

    @GetMapping("/find")
    public Employees findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return emplService.findEmpl(firstName, lastName);
    }

    @GetMapping("/print")
    public EmployeesService printAll() {
        return emplService;
    }
}
