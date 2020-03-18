package com.sparta.sf.DataStorage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginDetails {

    private String username;
    private String password;

    public void getLoginDetails() {
        Properties login = new Properties();
        try (FileReader in = new FileReader("resources/login.properties")) {
            login.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        username = login.getProperty("username");
        password = login.getProperty("password");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
