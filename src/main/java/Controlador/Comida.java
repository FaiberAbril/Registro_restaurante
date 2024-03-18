/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Conexion;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author CATA
 */
public class Comida {

    private Connection conn;

    public Comida() {
        Connection cn;
        Conexion conexionbasededatos = new Conexion();
        PreparedStatement ps;
        ResultSet rs;

   

    

    public void registrarComida(String estudiante) {
        try {
            String query = "INSERT INTO registro_comida (estudiante, fecha, hora) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, estudiante);
            pstmt.setString(2, LocalDate.now().toString());
            pstmt.setString(3, LocalTime.now().toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean consultarComida(LocalTime inicio, LocalTime fin) {
        try {
            String query = "SELECT COUNT(*) FROM registro_comida WHERE fecha = ? AND hora BETWEEN ? AND ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, LocalDate.now().toString());
            pstmt.setString(2, inicio.toString());
            pstmt.setString(3, fin.toString());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void borrarRegistrosDelDia() {
        try {
            String query = "DELETE FROM registro_comida WHERE fecha = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, LocalDate.now().toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ComidaRegistro registro = new ComidaRegistro();

        // Ejemplo de registro de comida para un estudiante
        registro.registrarComida("Estudiante1");

        // Consulta si un estudiante recibió comida entre las 9 am y las 10:30 am
        boolean recibioComida = registro.consultarComida(LocalTime.of(9, 0), LocalTime.of(10, 30));
        System.out.println("¿El estudiante recibió comida entre las 9 am y las 10:30 am? " + recibioComida);

        // Borra los registros del día
        registro.borrarRegistrosDelDia();
    }
}
