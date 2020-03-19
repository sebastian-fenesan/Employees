package com.sparta.sf.controller;

import com.sparta.sf.DataStorage.LoginDetails;
import com.sparta.sf.model.Employee;
import com.sparta.sf.model.EmployeeCsvReader;

import java.sql.*;
import java.util.Map;

public class EmployeeManager {

    public Map<String, Employee> createEmployeeMap () {
        EmployeeCsvReader employeeCsvReader = new EmployeeCsvReader();
        employeeCsvReader.csvReader();
        return employeeCsvReader.getEmployeeList();
    }

}
