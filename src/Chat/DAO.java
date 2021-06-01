/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import static Chat.Conexion.getInstance;
import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class DAO{
    
    Conexion con = getInstance();
    private Statement st;
    
    public void insertar(String usuario, String contraseña) {
        try {
            con.getSt().executeQuery("insert into acceso (contraseña, usuario) values ('"
                    +contraseña+"', '"
                    +usuario+"')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void update(String usuario, String contraseña) {
        try {
            con.getSt().executeQuery("update acceso"
                    + "\nset contraseña = '"+contraseña+                    
                    "\nwhere acceso.usuario = '"+usuario+"';");
        } catch (SQLException ex) {
            System.out.println("mamo");
        }
    }
    
    public String getDatos(String usuario){
        try {
            ResultSet result;
            result = con.getSt().executeQuery("select contraseña from acceso where usuario = "+"'"+usuario+"'");
            while (result.next()) {
                return result.getString(1);
            }
        } catch (Exception e) {
            System.out.println("No hay nada");
        }
        return "";
    }
    
}
