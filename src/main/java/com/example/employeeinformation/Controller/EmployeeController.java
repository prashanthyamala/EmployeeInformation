package com.example.employeeinformation.Controller;

import com.example.employeeinformation.model.Employee;
import com.example.employeeinformation.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    ObjectMapper mapper;

    @CrossOrigin
    @PostMapping(value = "/employeeSave", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) throws JsonProcessingException {
        try {
            return new ResponseEntity<String>(mapper.writeValueAsString(employeeService.saveEmployee(employee)), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @RequestMapping(value = "/id")
    public ResponseEntity<String> getBlogById( @RequestParam String Id)
            throws JsonProcessingException {
        try {
            return new ResponseEntity<String>(mapper.writeValueAsString(employeeService.getEmployeeId(Id)),
                    HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/above18")
    public ResponseEntity<List<Employee>> getAllEmployeeAbove18(){

        List<Employee> employees = employeeService.getAllEmployeesAbove18();
        employees.forEach(System.out::println);
        return  new ResponseEntity<>(employees,HttpStatus.OK);

    }
}

