/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.Registro_estudiante;

/**
 *
 * @author CATA
 */
public class Registrar_Estudiante {
    private int Id_estudiante;
    private String NomEstudiante;
    private String ApeEstudiante;
    private String TipoDocu;
    private String numeDocumento;
    private String Edad;
    private String Grado; 
    private String tipoBeneficio;
    private String Estado;

    public Registrar_Estudiante(int Id_estudiante, String NomEstudiante, String ApeEstudiante, String TipoDocu, String numeDocumento, String Edad, String Grado, String tipoBeneficio, String Estado) {
        this.Id_estudiante = Id_estudiante;
        this.NomEstudiante = NomEstudiante;
        this.ApeEstudiante = ApeEstudiante;
        this.TipoDocu = TipoDocu;
        this.numeDocumento = numeDocumento;
        this.Edad = Edad;
        this.Grado = Grado;
        this.tipoBeneficio = tipoBeneficio;
        this.Estado = Estado;
    }

    public Registrar_Estudiante() {
    }

    public int getId_estudiante() {
        return Id_estudiante;
    }

    public void setId_estudiante(int Id_estudiante) {
        this.Id_estudiante = Id_estudiante;
    }

    public String getNomEstudiante() {
        return NomEstudiante;
    }

    public void setNomEstudiante(String NomEstudiante) {
        this.NomEstudiante = NomEstudiante;
    }

    public String getApeEstudiante() {
        return ApeEstudiante;
    }

    public void setApeEstudiante(String ApeEstudiante) {
        this.ApeEstudiante = ApeEstudiante;
    }

    public String getTipoDocu() {
        return TipoDocu;
    }

    public void setTipoDocu(String TipoDocu) {
        this.TipoDocu = TipoDocu;
    }

    public String getNumeDocumento() {
        return numeDocumento;
    }

    public void setNumeDocumento(String numeDocumento) {
        this.numeDocumento = numeDocumento;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String Grado) {
        this.Grado = Grado;
    }

    public String getTipoBeneficio() {
        return tipoBeneficio;
    }

    public void setTipoBeneficio(String tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
 



  

  

    
    

