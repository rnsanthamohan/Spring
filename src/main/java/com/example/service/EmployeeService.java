package com.example.service;

import java.util.ArrayList;
import java.util.List;


import com.example.exception.EmployeeNotfoundException;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    private EmployeeRepository repository;

    public Employee getEmployeeById(int id) {
        return repository.findById(id).get();
    }
    public List<Employee> getAllEmployees(){
        logger.debug("Inside getAllEmployees");
        List<Employee> employees = new ArrayList<Employee>();
        repository.findAll().forEach(employee -> employees.add(employee));
        logger.info(String.format("Fetched %d employees", employees.size()));
        return employees;
    }
    public void saveOrUpdate(Employee employee) {
        if (employee.getId() > 100) {
            throw new EmployeeNotfoundException("Employee not found");
        }
        repository.save(employee);
    }
    public void deleteEmployeeById(int id) {
        repository.deleteById(id);
    }
}