package ru.lesson_4.java_junior_4.createDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDB {
    private final String nameDB;
    private final String nameTable;

    public CreateDB(String url, String nameDB, String nameTable) {
        this.nameDB = nameDB;
        this.nameTable = nameTable;

        ru.lesson_4.java_junior_4.createDB.CredentialsLoader credentialsLoader = new ru.lesson_4.java_junior_4.createDB.CredentialsLoader();
        String user = credentialsLoader.getUsername();
        String password = credentialsLoader.getPassword();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Создание базы данных
            createDatabase(connection);
            System.out.println("Database created successfully");

            // Использование базы данных
            useDatabase(connection);
            System.out.println("Use database successfully");

            //Создание таблицы
            createTable(connection);
            System.out.println("Create table successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + nameDB + ";";
        try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }

    private void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL = "USE " + nameDB + ";";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }
    }

    private void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS " + nameTable + " (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), duration INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }

}