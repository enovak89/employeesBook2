package com.example.employeesbook2.service;

import com.example.employeesbook2.employee.Employees;
import com.example.employeesbook2.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeesService {
    private Employees[] book = new Employees[3];
    private int count;


    public void addEmpl(String firstName, String lastName) {
       // if (count >= book.length) {
       // throw new EmployeeStorageIsFullException();
       // }
        //if (!findEmpl(firstName, lastName)) {
            book[count++] = new Employees(firstName, lastName);
       // } else {
        //throw new EmployeeAlreadyAddedException();
       // }
    }

    public void removeEmpl(Employees e) {
        for (int i = 0; i < book.length - 1; i++) {
            if (book[i].getFirstName().equals(e.getFirstName()) && book[i].getLastName().equals(e.getLastName())) {
                System.arraycopy(book, i + 1, book, i, book.length - 1 - i);
                System.out.println("Employees " + e.getFirstName() + " " + e.getLastName() + "was removed");
                book[book.length - 1] = null;
                count--;
                return;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public boolean findEmpl(String firstName, String lastName) {
        for (int i = 0; i < book.length - 1; i++) {
            if (book[i] != null && book[i].getFirstName().equals(firstName) && book[i].getLastName().equals(lastName)) {
                System.out.println("Employees " + firstName + " " + lastName+ "was finded");
                return true;
            }
        }
        throw new EmployeeNotFoundException();
    }


    public void printAll() {
        for (Employees e : book) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public Employees[] getBook() {
        return book;
    }

    public Integer getCount() {
        return count;
    }
}
