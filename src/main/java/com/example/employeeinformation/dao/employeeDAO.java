package com.example.employeeinformation.dao;

import com.example.employeeinformation.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

public interface employeeDAO {
    public String saveEmployee(Employee employee) ;

    public List<Employee> getEmployeeId(String Id) throws SQLException;


    String deleteEmployeeById(String Id);

    public List<Employee> getAllEmployeesAbove18() throws SQLException;

}
