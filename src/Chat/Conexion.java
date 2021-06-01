/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dani_
 */
public class Conexion {
    
    private Connection connection;
    private Statement st;
    private static Conexion conexion;

    private Conexion(){
    
    try {
            Class.forName("org.postgresql.Driver");
            this.connection = null;
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/acceso", "postgres", "1");
            this.st = this.connection.createStatement();          
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static Conexion getInstance(){
        if (conexion ==null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getSt() {
        return st;
    }
    
    
    
}
