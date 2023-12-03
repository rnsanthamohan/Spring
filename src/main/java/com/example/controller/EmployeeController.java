package com.example.controller;

import java.util.List;

import com.example.exception.EmployeeNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping(path = "/emp")
@ControllerAdvice
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

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
        if (employee.getId() > 100) {
            throw new EmployeeNotfoundException();
        }
        employeeService.saveOrUpdate(employee);
    }

    @ExceptionHandler(value = EmployeeNotfoundException.class)
    public ResponseEntity<Object> exception(EmployeeNotfoundException exception) {
        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
    }
}