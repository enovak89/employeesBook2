package com.example.employeesbook2.service;

import com.example.employeesbook2.employee.Employees;
import com.example.employeesbook2.exceptions.EmployeeAlreadyAddedException;
import com.example.employeesbook2.exceptions.EmployeeNotFoundException;
import com.example.employeesbook2.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeesService {
    private Integer listSize = 3;
    private ArrayList<Employees> book = new ArrayList<>(listSize);
    private int count;


    public void addEmpl(String firstName, String lastName) {
        if (count >= listSize) {
            throw new EmployeeStorageIsFullException("Превышена максимальная длинна списка");
        }
        Employees employees = new Employees(firstName, lastName);
        if (!book.contains(employees)) {
            book.add(count++, employees);
            System.out.println("Employees " + firstName + " " + lastName + " was added" + count + " " + book.size());
        } else {
            throw new EmployeeAlreadyAddedException("Сотрудник с такими данными уже есть в списке");
        }
    }

    public Employees removeEmpl(String firstName, String lastName) {

        Employees employees = new Employees(firstName, lastName);
        if (book.contains(employees)) {
            book.remove(employees);
            System.out.println("Employees " + firstName + " " + lastName + " was removed");
            return employees;
        }
        throw new EmployeeNotFoundException("Сотрудник с такими данными не найден");
    }

    public Employees findEmpl(String firstName, String lastName) {
        Employees employees = new Employees(firstName, lastName);
        if (book.contains(employees)) {
            return employees;
        }
        throw new EmployeeNotFoundException("Сотрудник с такими данными не найден");
    }


    public void printAll() {
        for (Employees e : book) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public ArrayList<Employees> getBook() {
        return book;
    }

    public Integer getCount() {
        return count;
    }

}
