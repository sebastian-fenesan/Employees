package com.sparta.sf.DataStorage;

import com.sparta.sf.controller.EmployeeManager;
import com.sparta.sf.model.Employee;
import com.sparta.sf.model.EmployeeCsvReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class EmployeeDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/employees";

    public static void populateDatabase() {
        try (Connection connection = DriverManager.getConnection(URL, "root", "root")) {
            EmployeeManager employeeManager = new EmployeeManager();
            Map<String, Employee> employeeMap = employeeManager.createEmployeeMap();
            for (Object employee : employeeMap.values()) {
                employeeManager.createEmployeeRecord((Employee) employee, connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
