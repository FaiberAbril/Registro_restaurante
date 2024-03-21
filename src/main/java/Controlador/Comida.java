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
import java.sql.Statement;
import java.sql.Time;
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
}
/**
 * public void insertarRegistro(int numDocumento, boolean comida_recibida) { try
 * {
 *
 * String query = "INSERT INTO registros (estudiante_id, fecha, hora_comida,
 * comida_recibida) VALUES (?, DATE('now'), TIME('now'))VALUES(?,?,?)";
 * PreparedStatement pstmt = cn.prepareStatement(query); pstmt.setInt(1,
 * numDocumento); pstmt.setBoolean(2, comida_recibida); pstmt.executeUpdate(); }
 * catch (SQLException e) { System.out.println("Error al insertar registro: " +
 * e.getMessage()); } }
 *
 * public boolean consultarComida(LocalTime inicio, LocalTime fin) { try {
 * String query = "SELECT COUNT(*) FROM registro_comida WHERE fecha = ? AND hora
 * BETWEEN ? AND ?"; PreparedStatement pstmt = cn.prepareStatement(query);
 * pstmt.setString(1, LocalDate.now().toString()); pstmt.setString(2,
 * inicio.toString()); pstmt.setString(3, fin.toString()); ResultSet rs =
 * pstmt.executeQuery(); if (rs.next()) { int count = rs.getInt(1); return count
 * > 0; } } catch (SQLException e) { e.printStackTrace(); } return false; }
 *
 * public boolean verificarComidaPorHora(int estudianteId, Time horaInicio, Time
 * horaFin) { try { String query = "SELECT * FROM registros WHERE estudiante_id
 * = ? AND hora_comida BETWEEN ? AND ?"; PreparedStatement pstmt =
 * cn.prepareStatement(query); pstmt.setInt(1, estudianteId); pstmt.setTime(2,
 * horaInicio); pstmt.setTime(3, horaFin); ResultSet rs = pstmt.executeQuery();
 * return rs.next(); // Devuelve true si hay registros para el estudiante en ese
 * rango de horas } catch (SQLException e) { System.out.println("Error al
 * verificar comida por hora: " + e.getMessage()); return false; } }
 *
 * // Método para borrar los registros de comida de los estudiantes al final
 * del día public void borrarRegistrosDiarios() { try { String query = "DELETE
 * FROM registro_comida WHERE fecha = ?"; PreparedStatement pstmt =
 * cn.prepareStatement(query); } catch (SQLException e) {
 * System.out.println("Error al borrar registros diarios: " + e.getMessage()); }
 * }
 *
 * // Método principal para probar la funcionalidad public static void
 * main(String[] args) { Comida registroComida = new Comida();
 *
 * // Suponiendo que el estudiante con ID 1 recibe comida a las 9 am
 * registroComida.insertarRegistro(1, true);
 *
 * // Suponiendo que el estudiante con ID 2 no recibe comida a las 10 am
 * registroComida.insertarRegistro(2, false);
 *
 * // Verificar si los estudiantes recibieron comida entre las 9 am y las 10:30
 * am boolean estudiante1Comio = registroComida.verificarComidaPorHora(1,
 * Time.valueOf("09:00:00"), Time.valueOf("10:30:00")); boolean estudiante2Comio
 * = registroComida.verificarComidaPorHora(2, Time.valueOf("09:00:00"),
 * Time.valueOf("10:30:00"));
 *
 * // Mostrar los resultados System.out.println("Estudiante 1 recibió comida
 * entre las 9 am y las 10:30 am: " + estudiante1Comio);
 * System.out.println("Estudiante 2 recibió comida entre las 9 am y las 10:30
 * am: " + estudiante2Comio);
 *
 * // Borrar los registros al final del día
 * registroComida.borrarRegistrosDiarios(); }*
 */
