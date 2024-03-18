/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author CATA
 */
public class registro_comida extends JFrame implements ActionListener {

    private JLabel txtRecibio;
    private JButton btnRegistro;

    Connection cn;
    Conexion conexionbasededatos = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public registro_comida() {
        super("Registro de Comida");

        // Configurar la interfaz gráfica
        txtRecibio = new JLabel();
        btnRegistro = new JButton("Consultar");

        btnRegistro.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(btnRegistro);
        panel.add(txtRecibio);

        add(panel);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Método para consultar si el estudiante ha recibido comida
    private void consultarComida() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            cn = conexionbasededatos.getconeccionbasedatos();
            PreparedStatement ps = null;
            stmt = conn.createStatement();

            
            LocalTime horaActual = LocalTime.now();
            
            LocalDate fechaActual = LocalDate.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            
            String query = "SELECT * FROM registro_comida WHERE fecha = '" + fechaActual + "' AND hora BETWEEN '09:00:00' AND '10:30:00'";

            rs = stmt.executeQuery(query);

            if (rs.next()) {
                
                txtRecibio.setText("El estudiante ya recibió comida de 9 am a 10:30 am");
            } else {
                
                txtRecibio.setText("El estudiante no ha recibido comida de 9 am a 10:30 am");
            }

           
            if (horaActual.isAfter(LocalTime.parse("12:00:00", formatter)) && horaActual.isBefore(LocalTime.parse("14:30:00", formatter))) {
                
                String query2 = "SELECT * FROM registro_comida WHERE fecha = '" + fechaActual + "' AND hora BETWEEN '09:00:00' AND '10:30:00'";

                rs = stmt.executeQuery(query2);

                if (rs.next()) {
                   
                    txtRecibio.setText(txtRecibio.getText() + "\nEl estudiante ha tomado comida de 9 am a 10:30 am");
                } else {
                   
                    txtRecibio.setText(txtRecibio.getText() + "\nEl estudiante no ha tomado comida de 9 am a 10:30 am");
                }
            }

           
            if (horaActual.equals(LocalTime.parse("23:59:00", formatter))) {
                String deleteQuery = "DELETE FROM registro_comida WHERE fecha = '" + fechaActual + "'";
                stmt.executeUpdate(deleteQuery);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistro) {
            consultarComida();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(registro_comida::new);
    }
}
