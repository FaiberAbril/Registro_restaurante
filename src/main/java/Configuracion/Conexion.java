/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author CATA
 */
public class Conexion {

     Connection conecction;

    public Conexion() {
        
        String urldb="jdbc:mysql://localhost:3306/db_restaurante";
        String usuariodb="root";
        String contrasenadb="";
        
            try {
            conecction = DriverManager.getConnection(urldb, usuariodb, contrasenadb);
            System.out.println("conexion exitosa a la base de datos");  
        } catch (Exception e) {

            System.out.println(String.valueOf(e));
        }
   
    }
     
    
    public Connection getconeccionbasedatos() {
        return conecction;
    }

}
