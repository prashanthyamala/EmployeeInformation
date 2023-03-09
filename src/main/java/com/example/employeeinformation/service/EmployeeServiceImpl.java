package com.example.employeeinformation.service;

import com.example.employeeinformation.dao.employeeDAO;
import com.example.employeeinformation.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService{


    @Autowired
    private employeeDAO empDao;

    @Override
    public String saveEmployee(Employee employee) {
        try{
            return empDao.saveEmployee(employee);
    } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Employee> getEmployeeId(String Id) {
        try {
            return empDao.getEmployeeId(Id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String deleteEmployeeById(String Id) {
        try {
            return empDao.deleteEmployeeById(Id);
        }catch(Exception e){
            throw new RuntimeException();

    }


    }

    @Override
    public List<Employee> getAllEmployeesAbove18() {
        try{
            return empDao.getAllEmployeesAbove18();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
