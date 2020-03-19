package com.sparta.sf.DataStorage;

import com.sparta.sf.controller.EmployeeManager;
import com.sparta.sf.model.Employee;
import com.sparta.sf.model.EmployeeCsvReader;

import java.sql.*;
import java.util.Map;

public class EmployeeDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/employees";
    private String CREATE_EMPLOYEE_RECORD = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?)";
    private String GET_EMPLOYEE_RECORD = "SELECT * FROM employees WHERE employee_id = ?";

    public void createEmployeeRecord(Employee employee, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(CREATE_EMPLOYEE_RECORD);
        statement.setString(1, employee.getEmployeeID());
        statement.setString(2, employee.getTitleOfCourtesy());
        statement.setString(3, employee.getFirstName());
        statement.setString(4, employee.getMiddleInitial());
        statement.setString(5, employee.getLastName());
        statement.setString(6, employee.getGender());
        statement.setString(7, employee.getEmail());
        statement.setDate(8, Date.valueOf(employee.getDateOfBirth()));
        statement.setDate(9, Date.valueOf(employee.getDateOfJoining()));
        statement.setInt(10, employee.getSalary());
        statement.executeUpdate();
    }

    public void populateDatabase() {
        String[] details = LoginDetails.getLoginDetails();
        try (Connection connection = DriverManager.getConnection(URL, details[0], details[1])) {
            EmployeeManager employeeManager = new EmployeeManager();
            Map<String, Employee> employeeMap = employeeManager.createEmployeeMap();
            for (Object employee : employeeMap.values()) {
                createEmployeeRecord((Employee) employee, connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

