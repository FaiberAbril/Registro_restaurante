/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Metodos;
import Modelo.Registrar_Admin;
import Vista.Login;
import Vista.Registro_admin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controladorAdmin implements ActionListener  {
    
    Metodos met=new Metodos();
    Registrar_Admin x= new Registrar_Admin();
    Login log=new Login();
    Registro_admin reg=new Registro_admin();
    
 

      public controladorAdmin(Login log, Registrar_Admin user, Registro_admin reg){
        this.log=log; 
        this.reg=reg;
        this.x= user;
        
        this.reg.btnGuardar.addActionListener(this);
        this.log.btnIngresar.addActionListener(this);
    }
 
    
    
    public void Guardar(){
    
  
    x.setNombres(reg.txtApellido.getText());
    x.setApellidos(reg.txtApellido.getText());
    x.setTipoDocumento((String) reg.cbtipo.getSelectedItem());
    x.setNumDocumento(reg.txtNumDocu.getText());
    x.setCargo(reg.txtcargo.getText());
    x.setUsuario(reg.txtUsuario.getText());
    x.setPass(reg.pwPass.getText());
    
    
    if(met.InsertarUsuarioAdmin(x)){
    
        JOptionPane.showMessageDialog(null, "Persona Registrada");
    
    }else{
        JOptionPane.showMessageDialog(null, "Error al Registrar");
        
    }
    
    }
    
    public void Ingreso(){
    
      String us=log.tUser.getText();
      String pw=log.tpass.getText();
      
      if(met.Autenticacion(us, pw)){
      JOptionPane.showMessageDialog(null, "Logueo Correcto");
      
      }else{
      
          JOptionPane.showMessageDialog(null, "Error de Logueo");
          
      }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == reg.btnGuardar){
        Guardar();
        }
        if(e.getSource() == log.btnIngresar){
        Ingreso();
        } 
       }
    
}
