package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>  {
    public List<Employee> findByName(String name);
    public List<Employee> findByAge(int age);

    @Query(value = "SELECT e FROM Employee e ORDER BY name")
    public List<Employee> findAllSortedByName();
}
