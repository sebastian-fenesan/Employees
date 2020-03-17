package com.sparta.sf.controller;

import com.sparta.sf.model.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeCsvReader {

    private Map<String, Employee> employeeList = new HashMap<>();
    private List<Employee> corruptEmployeeList = new ArrayList<>();

    public void csvReader() {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("resources/EmployeeRecords.csv"));
            String row = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                Employee employee = createEmployee(data);
                if (!(employeeList.keySet().contains(employee.getEmployeeID()))) {
                    employeeList.put(employee.getEmployeeID(), employee);
                    System.out.println(employee.toString());
                } else {
                    corruptEmployeeList.add(employee);
                }
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Employee> getCorruptEmployeeList() {
        return corruptEmployeeList;
    }

    private Employee createEmployee(String[] metadata) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String employeeID = metadata[0];
        String titleOfCourtesy = metadata[1];
        String firstName = metadata[2];
        String middleInitial = metadata[3];
        String lastName = metadata[4];
        String gender = metadata[5];
        String email = metadata[6];
        LocalDate dateOfBirth = LocalDate.parse(metadata[7], formatter);
        LocalDate dateOfJoining = LocalDate.parse(metadata[8], formatter);
        int salary = Integer.parseInt(metadata[9]);

        return new Employee(employeeID, titleOfCourtesy, firstName, middleInitial, lastName, gender, email, dateOfBirth, dateOfJoining, salary);
    }
}
