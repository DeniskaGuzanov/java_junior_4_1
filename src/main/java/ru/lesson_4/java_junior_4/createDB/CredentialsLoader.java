package ru.lesson_4.java_junior_4.createDB;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredentialsLoader {
    private String username;
    private String password;

    public CredentialsLoader() {
        Properties properties = new Properties();
        try (InputStream input = CredentialsLoader.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return;
            }

            // Загрузка свойств из файла
            properties.load(input);

            // Получение значений
            username = properties.getProperty("username");
            password = properties.getProperty("password");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
