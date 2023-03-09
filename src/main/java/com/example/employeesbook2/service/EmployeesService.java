package com.example.employeesbook2.service;

import com.example.employeesbook2.employee.Employees;
import com.example.employeesbook2.exceptions.EmployeeAlreadyAddedException;
import com.example.employeesbook2.exceptions.EmployeeNotFoundException;
import com.example.employeesbook2.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeesService {
    private Integer listSize = 3;
    private Map<Integer, Employees> book = new HashMap<>();
    private Integer count = 0;


    public Employees addEmpl(String firstName, String lastName) {
        if (count >= listSize) {
            throw new EmployeeStorageIsFullException("Превышена максимальная длинна хранилища");
        }
        Employees employees = new Employees(firstName, lastName);
        if (book.containsValue(employees)) {
            employees = null;
            throw new EmployeeAlreadyAddedException("Сотрудник с такими данными уже есть в хранилище");
        }
        book.put(count++, employees);
        System.out.println("Employees " + firstName + " " + lastName + " was added" + count + " " + book.size());
        printAll();
        return employees;
    }

    public Employees removeEmpl(String firstName, String lastName) {
        Employees employees = new Employees(firstName, lastName);
        if (book.containsValue(employees)) {
            book.remove(count--);
            System.out.println("Employees " + firstName + " " + lastName + " was removed");
            printAll();
            return employees;
        }
        employees = null;
        throw new EmployeeNotFoundException("Сотрудник с такими данными не найден");
    }

    public Employees findEmpl(String firstName, String lastName) {
        Employees employees = new Employees(firstName, lastName);
        if (book.containsValue(employees)) {
            printAll();
            return new Employees(firstName, lastName);
        }
        employees = null;
        throw new EmployeeNotFoundException("Сотрудник с такими данными не найден");
    }


    public void printAll() {
        System.out.println(book);
    }

    public Map<Integer, Employees> getBook() {
        return book;
    }

    public Integer getCount() {
        return count;
    }

}
