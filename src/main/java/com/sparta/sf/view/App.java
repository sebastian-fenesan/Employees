package com.sparta.sf.view;

import com.sparta.sf.controller.EmployeeManager;

public class App 
{
    public static void main( String[] args ) {

        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.populateDatabase();
    }
}
