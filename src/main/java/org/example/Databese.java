package org.example;


import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databese {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/megasofttest13";
    private static final String DB_USER = "Danil";
    private static final String DB_PASSWORD = "astra121";

    static {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/megasofttest13", "Danil", "astra121")
                .locations("db/migration")// Устанавливаем начальную точку для миграций
                .load();

        flyway.migrate();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
