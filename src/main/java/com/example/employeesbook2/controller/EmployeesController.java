package com.example.employeesbook2.controller;

import com.example.employeesbook2.employee.Employees;
import com.example.employeesbook2.service.EmployeesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    private final EmployeesService employeesService;


    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    EmployeesService emplService = new EmployeesService();

    @GetMapping("/add")
    public Employees addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        emplService.addEmpl(firstName, lastName);
        Employees employees = emplService.getBook()[emplService.getCount() - 1];
        return employees;
    }
}
