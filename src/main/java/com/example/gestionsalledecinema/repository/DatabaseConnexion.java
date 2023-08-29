package com.example.gestionsalledecinema.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnexion {
    @Bean
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/gestion_cinema",
                "postgres",
                "tiavina"
        );
    }

}
