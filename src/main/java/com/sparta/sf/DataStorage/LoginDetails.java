package com.sparta.sf.DataStorage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginDetails {

    public static String[] getLoginDetails() {
        String[] details = new String[2];
        Properties login = new Properties();
        try (FileReader in = new FileReader("resources/login.properties")) {
            login.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        details[0] = login.getProperty("username");
        details[1] = login.getProperty("password");
        return details;
    }
}
