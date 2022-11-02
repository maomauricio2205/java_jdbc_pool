package org.aguzman.java.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Bogota";
    private static String username = "root";
    private static String password = "admin";

    private static BasicDataSource pool;

    //pool de conexiones
    public static BasicDataSource getInstance() throws SQLException {
        if (pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setInitialSize(3);
            pool.setMinIdle(3); //minimo de conexiones inactivas
            pool.setMaxIdle(8); //maximo de conexiones inactivas
            pool.setMaxTotal(8);
        }
        return pool;
    }

    //retorna la conexion a la BD
    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
