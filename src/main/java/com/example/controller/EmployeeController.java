package com.example.controller;

import java.util.List;

import com.example.exception.EmployeeNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployeeById(id);
    }
    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.saveOrUpdate(employee);
    }
    @PutMapping("/employee")
    public void updateEmployee(@RequestBody Employee employee) throws EmployeeNotfoundException {
        employeeService.saveOrUpdate(employee);
    }
}