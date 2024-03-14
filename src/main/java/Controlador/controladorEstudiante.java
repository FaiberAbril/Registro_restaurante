/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Conexion;
import Modelo.Registrar_Estudiante;

import Vista.Registro_estudiante;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author CATA
 */
public class controladorEstudiante implements ActionListener {

    Registrar_Estudiante e = new Registrar_Estudiante();
    Registro_estudiante Reg = new Registro_estudiante();

    Connection cn;
    Conexion conexionbasededatos = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public controladorEstudiante() {
        
    }
    

    public controladorEstudiante(Registrar_Estudiante usuario, Registro_estudiante Reg) {
        this.e = usuario;
        this.Reg = Reg;
        this.Reg.btnguardar2.addActionListener(this);

    }

    public String  Guarda() {
    String nomEstu = Reg.txtnomEstu.getText();
    String apeEstu = Reg.txtapeEstu.getText();
    String tipoDocu = (String) Reg.cbTipo.getSelectedItem();
    String numDocumento = Reg.txtnumEstu.getText();
    String edad = Reg.txtEdad.getText();
    String grado = Reg.txtGrado.getText();
    String tipoBeneficio = (String) Reg.cbBeneficio.getSelectedItem();
    String estado = (String) Reg.cbEstado.getSelectedItem();
    
    
   /*

    if (nomEstu.isEmpty() || apeEstu.isEmpty() || tipoDocu.isEmpty()
            || numDocumento.isEmpty() || edad.isEmpty() || grado.isEmpty()
            || tipoBeneficio.isEmpty() || estado.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        System.out.println(numDocumento+"-"+ apeEstu+"-"+ tipoDocu +"-"+ nomEstu+"-"+edad+"-"+grado+"-"+tipoBeneficio+"-"+estado);
        return null;
    }      
        */
   
        e.setNomEstudiante(Reg.txtnomEstu.getText());
        e.setApeEstudiante(Reg.txtapeEstu.getText());
        e.setTipoDocu((String) Reg.cbTipo.getSelectedItem());
        e.setNumeDocumento(Reg.txtnumEstu.getText());
        e.setEdad(Reg.txtEdad.getText());
        e.setGrado(Reg.txtGrado.getText());
        e.setTipoBeneficio((String) Reg.cbBeneficio.getSelectedItem());
        e.setEstado((String) Reg.cbEstado.getSelectedItem());
        
       

        
      return e.getNumeDocumento();
    }
    

    public boolean InsertarEstudiante(Registrar_Estudiante e) {

        cn = conexionbasededatos.getconeccionbasedatos();
        PreparedStatement ps = null;

        String sql = "insert into Registrar_Estudiante(Id_estudiante,NomEstudiante,ApeEstudiante,TipoDocu,numeDocumento,Edad,Grado,tipoBeneficio,Estado) values (?,?,?,?,?,?,?,?,?)";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, e.getId_estudiante());
            ps.setString(2, e.getNomEstudiante());
            ps.setString(3, e.getApeEstudiante());
            ps.setString(4, e.getTipoDocu());
            ps.setString(5, e.getNumeDocumento());
            ps.setString(6, e.getEdad());
            ps.setString(7, e.getGrado());
            ps.setString(8, e.getTipoBeneficio());
            ps.setString(9, e.getEstado());
            ps.execute();
            cn.close();
            Guarda();
            return true;

        } catch (Exception error) {
            System.out.println(error);
        }
        return false;

    }

    @Override
    public void actionPerformed(ActionEvent s) {
                 
        
        if (s.getSource() == Reg.btnguardar2) {
           String numeroDocumento = Guarda();
           int numeroDocumentoEntero = Integer.parseInt(numeroDocumento);
           
           if(numeroDocumentoEntero > 0){
           Reg.captureAndSaveImage(numeroDocumento);
           }
           
           
            
        }
    }

    public void Actualizar(Registrar_Estudiante actualizar) {

        String sql = "update Registrar_Estudiante set Id_estudiante=?, NomEstudiante=?, ApeEstudiante=?, TipoDocu=?, numeDocumento=?, Edad=?, Grado=?, tipoBeneficio=?, Estado=?";

        try {
            cn = conexionbasededatos.getconeccionbasedatos();
            ps = cn.prepareStatement(sql);
            ps.setString(2, actualizar.getNomEstudiante());
            ps.setString(3, actualizar.getApeEstudiante());
            ps.setString(4, actualizar.getTipoDocu());
            ps.setString(5, actualizar.getNumeDocumento());
            ps.setString(6, actualizar.getEdad());
            ps.setString(7, actualizar.getGrado());
            ps.setString(8, actualizar.getTipoBeneficio());
            ps.setString(9, actualizar.getEstado());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void Eliminar(String numeDocumento) {
        String sql = "DELETE from Registrar_Estudiante WHERE numeDocumento=?";

        try {
            cn = conexionbasededatos.getconeccionbasedatos();
            ps = cn.prepareStatement(sql);
            ps.setString(1, numeDocumento);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Registrar_Estudiante> listar() {
        List<Registrar_Estudiante> listar = new ArrayList<>();
        String sql = "select * from registrar_estudiante ";

        try {
            cn = conexionbasededatos.getconeccionbasedatos();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Registrar_Estudiante estudiantes = new Registrar_Estudiante();

                estudiantes.setId_estudiante(rs.getInt(1));
                estudiantes.setNomEstudiante(rs.getString(2));
                estudiantes.setApeEstudiante(rs.getString(3));
                estudiantes.setTipoDocu(rs.getString(4));
                estudiantes.setNumeDocumento(rs.getString(5));
                estudiantes.setEdad(rs.getString(6));
                estudiantes.setGrado(rs.getString(7));
                estudiantes.setTipoBeneficio(rs.getString(8));
                estudiantes.setEstado(rs.getString(9));

                listar.add(estudiantes);

            }

        }catch(SQLException e){
            System.out.println(e.getMessage());        
        }
    return listar;
    }

    
    
    
    
}
