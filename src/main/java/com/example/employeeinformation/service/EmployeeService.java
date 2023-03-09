package com.example.employeeinformation.service;

import com.example.employeeinformation.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService  {

    public String saveEmployee(Employee employee);

    public List<Employee> getEmployeeId(String Id);

    public String deleteEmployeeById(String Id);
    public List<Employee> getAllEmployeesAbove18();


}
