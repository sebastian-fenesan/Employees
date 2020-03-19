package com.sparta.sf.view;

import com.sparta.sf.DataStorage.EmployeeDAO;
import com.sparta.sf.controller.EmployeeManager;

public class App 
{
    public static void main( String[] args ) {

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.populateDatabase();
    }
}
