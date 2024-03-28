package com.crud.demo.controller;

import com.crud.demo.model.Employee;
import com.crud.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    //add
    @PostMapping("")
    public Employee addEmployee(@RequestBody Employee employee) {
        return iEmployeeService.addEmployee(employee);
    }

    //update
    @PutMapping("")
    public Employee updateEmployee(@RequestParam("id") long id, @RequestBody Employee employee) {
        return iEmployeeService.updateEmployee(id, employee);
    }

    //delete
    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable("id") long id) {
        return iEmployeeService.deleteEmployee(id);
    }

    //get all
    @GetMapping("")
    public List<Employee> getAllEmployee(){
        return iEmployeeService.getAllEmployee();
    }

    //get one
    @GetMapping("/{id}")
    public Employee getOneEmployee(@PathVariable("id") long id) {
        return iEmployeeService.getOneEmployee(id);
    }
}
