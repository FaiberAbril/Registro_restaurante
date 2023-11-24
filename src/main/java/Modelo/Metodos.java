/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author CATA
 */
public class Metodos {
    
    
      Conexion conexionbasededatos= new Conexion();
    
    

    public boolean InsertarUsuarioAdmin(Registrar_Admin x) {

        
    
      
        Connection cn = conexionbasededatos.getconeccionbasedatos();
        PreparedStatement ps = null;

        String sql = "insert into Registrar_Admin(IdUsuario,Nombres,Apellidos,TipoDocumento,NumDocumento,Cargo,Usuario,Pass) values (?,?,?,?,?,?,?,?)";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, x.getIdUsuario());
            ps.setString(2, x.getNombres());
            ps.setString(3, x.getApellidos());
            ps.setString(4, x.getTipoDocumento());
            ps.setString(5, x.getNumDocumento());
            ps.setString(6, x.getCargo());
            ps.setString(7, x.getUsuario());
            ps.setString(8, x.getPass());
            ps.execute();
            cn.close();
            return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean Autenticacion(String Puser, String Ppsw) {

        Connection cn = conexionbasededatos.getconeccionbasedatos();
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        String sql="select Usuario,Pass from Registrar_Admin where Usuario=? and Pass=?";
        try{
        ps=cn.prepareStatement(sql);
        ps.setString(1, Puser);
        ps.setString(2, Ppsw);
        rs=ps.executeQuery();
        
        while(rs.next()){
        
          cn.close();
          return true;
        }
        
        }catch (Exception e){
        
            System.out.println(e);
        }
        return false;
    }
}
