package com.crud.demo.service;

import com.crud.demo.model.Employee;

import java.util.List;

public interface IEmployeeService {
    //add an employee
    public Employee addEmployee(Employee employee);

    //update an employee
    public Employee updateEmployee(long id, Employee employee);

    //delete an employee
    public boolean deleteEmployee(long id);

    //get list employees
    public List<Employee> getAllEmployee();

    //get an employee
    public Employee getOneEmployee(long id);
}
