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
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

    public Boolean validarEstudiante(String numDocumento) {
        Connection cn = conexionbasededatos.getconeccionbasedatos();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "select * from mensajes where numDocumento=?";

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, numDocumento);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar el mensaje en la base de datos: " + e.getMessage());
        }

        return false;

    }

    public void guardarMensaje(String numDocumento, String mensaje, String tipoBeneficio) {
        PreparedStatement ps = null;
        String sql = "INSERT INTO mensajes (numDocumento, mensaje, tipoBeneficio) VALUES (?, ?, ?)";

        if (validarEstudiante(numDocumento) == true) {
            JOptionPane.showMessageDialog(null, "YA RECIBIO EL BENEFICIO \n "  +  tipoBeneficio);

        } else {
            try {
                cn = conexionbasededatos.getconeccionbasedatos();

                LocalTime horaActual = LocalTime.now();
                LocalTime horaInicio = LocalTime.of(8, 40);
                LocalTime horaFin = LocalTime.of(10, 30);
                if (horaActual.isAfter(horaInicio) && horaActual.isBefore(horaFin)) {
                    ps = cn.prepareStatement(sql);
                    ps.setString(1, numDocumento);
                    ps.setString(2, mensaje);
                    ps.setString(3, tipoBeneficio);
                   
                    ps.executeUpdate();
                    System.out.println("Mensaje guardado exitosamente en la base de datos.");
                } else {
                    System.out.println("No se puede guardar el mensaje en este momento.");
                }
            } catch (SQLException e) {
                System.err.println("Error al guardar el mensaje en la base de datos: " + e.getMessage());
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (cn != null) {
                        cn.close();
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar la conexión: " + ex.getMessage());
                }
            }

        }

    }

}
