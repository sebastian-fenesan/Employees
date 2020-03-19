package com.sparta.sf.controller;

import com.sparta.sf.DataStorage.LoginDetails;
import com.sparta.sf.model.Employee;
import com.sparta.sf.model.EmployeeCsvReader;

import java.sql.*;
import java.util.Map;

public class EmployeeManager {

    private static final String URL = "jdbc:mysql://localhost:3306/employees";

    private String CREATE_EMPLOYEE_RECORD = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?)";
    private String GET_EMPLOYEE_RECORD = "SELECT * FROM employees WHERE employee_id = ?";

    public Map<String, Employee> createEmployeeMap () {
        EmployeeCsvReader employeeCsvReader = new EmployeeCsvReader();
        employeeCsvReader.csvReader();
        return employeeCsvReader.getEmployeeList();
    }

    public Connection connectToDatabase () {
        String[] details = LoginDetails.getLoginDetails();
        try (Connection connection = DriverManager.getConnection(URL, details[0], details[1])) {
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
