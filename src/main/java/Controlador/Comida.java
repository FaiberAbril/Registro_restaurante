/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Conexion;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author CATA
 */
public class Comida {

    Connection cn;
    Conexion conexionbasededatos = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
   
    
    public Comida() {
     
    }

    public void guardarMensaje(String numDocumento, String mensaje) {
       
  
        PreparedStatement ps = null;
        String sql = "INSERT INTO mensajes (numDocumento,mensaje) VALUES (?,?)";
        try {
            cn = conexionbasededatos.getconeccionbasedatos();
            ps = cn.prepareStatement(sql);
            ps.setString(1, numDocumento);
            ps.setString(2, mensaje);
            ps.executeUpdate();

        } catch (SQLException e) {

        }
        
        
        
        
        
    }


   public boolean consultarMensajes(String numDocumento) {

      
       
        try  {
            String sql = "SELECT mensaje FROM mensajes WHERE TIME(hora_recepcion) BETWEEN '09:00:00' AND '10:30:00'";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    
                }
            }
        } catch (SQLException e) {
            
        }
        
        return true;
    }
}


