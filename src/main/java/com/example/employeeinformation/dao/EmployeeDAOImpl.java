package com.example.employeeinformation.dao;

import ch.qos.logback.classic.Logger;
import com.example.employeeinformation.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class EmployeeDAOImpl implements employeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String saveEmployee(Employee employee) {
        String response = null;
        int status = 0;
        String empDetails = "Insert into projectdb.employee(Id,name,age,maritalStatus,citizenship)"
                + "values (?,?,?,?,?)";

        try (Connection conn = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
             CallableStatement cs = conn.prepareCall(empDetails);) {

            cs.setString(1, employee.getId());
            cs.setObject(2, employee.getName());
            cs.setObject(3, employee.getAge());
            cs.setString(4, employee.getMaritalStatus());
            cs.setString(5, employee.getCitizenship());

            System.out.println(cs);

            status = cs.executeUpdate();

            if (status > 0) {
                response = "success";
            } else {
                response = "Failure";
            }


        } catch (Exception e) {
            throw new RuntimeException();
        }
        return response;
    }

    @Override
    public List<Employee> getEmployeeId(String Id) {
        String query = "select * from employee where Id=?";
        List<Employee> list = null;
        try (Connection conn = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(query);) {
            list = new ArrayList<Employee>();
            ps.setString(1, Id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Employee report = new Employee();
                    report.setId(rs.getString("Id"));
                    report.setName(rs.getString("name"));
                    report.setAge(Integer.parseInt(rs.getString("age")));
                    report.setMaritalStatus(rs.getString("maritalStatus"));
                    report.setCitizenship(rs.getString("citizenship"));
                    list.add(report);
                    ;
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public String deleteEmployeeById(String Id) {
        String response = null;
        int status = 0;
        String empDelete = "delete from employee where Id=?";
        try (Connection conn = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cs = conn.prepareCall(empDelete);) {

            cs.setString(1, Id);
            status = cs.executeUpdate();
            if (status > 0) {
                response = "sucess";
            } else {
                response = "Failure";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response;

    }

    @Override
    public List<Employee> getAllEmployeesAbove18() throws SQLException {

        String query1 = "select * from employee where age>18";

        List<Employee> list1 = null;
        try (Connection conn = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps1 = conn.prepareStatement(query1);) {
            list1 = new ArrayList<Employee>();
            try (ResultSet result = ps1.executeQuery()) {
                while (result.next()) {
                    Employee report = new Employee();
                    report.setId(result.getString("Id"));
                    report.setName(result.getString("name"));
                    report.setAge(Integer.parseInt(result.getString("age")));
                    report.setMaritalStatus(result.getString("maritalStatus"));
                    report.setCitizenship(result.getString("citizenship"));
                    list1.add(report);
                    ;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        List<Employee> list3 = list1.stream()
                .filter(e -> e.getAge() > 18)
                .collect(Collectors.toList());
        return list1;
    }
}
