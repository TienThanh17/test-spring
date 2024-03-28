package com.crud.demo.service;

import com.crud.demo.model.Employee;
import com.crud.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        if(employee != null) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        if (employee != null) {
            Employee employee1 = employeeRepository.getById(id);
            if (employee1 != null) {
                employee1.setName(employee.getName());
                employee1.setAddress(employee.getAddress());

                return employeeRepository.save(employee1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(long id) {
        try {
            Employee employee = employeeRepository.getById(id);
            System.out.println(employee);
            if(employee != null) {
                employeeRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace(); // This prints the exception stack trace to the console
            return false;
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

//    @Override
//    public Employee getOneEmployee(long id) {
//        return employeeRepository.findById(id).get();
//    }
    @Override
    public Employee getOneEmployee(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("cannot find id: "+id));
    }
}
