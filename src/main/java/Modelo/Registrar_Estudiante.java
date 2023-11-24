/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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

    /**
     * @return the Id_estudiante
     */
    public int getId_estudiante() {
        return Id_estudiante;
    }

    /**
     * @param Id_estudiante the Id_estudiante to set
     */
    public void setId_estudiante(int Id_estudiante) {
        this.Id_estudiante = Id_estudiante;
    }

    /**
     * @return the NomEstudiante
     */
    public String getNomEstudiante() {
        return NomEstudiante;
    }

    /**
     * @param NomEstudiante the NomEstudiante to set
     */
    public void setNomEstudiante(String NomEstudiante) {
        this.NomEstudiante = NomEstudiante;
    }

    /**
     * @return the ApeEstudiante
     */
    public String getApeEstudiante() {
        return ApeEstudiante;
    }

    /**
     * @param ApeEstudiante the ApeEstudiante to set
     */
    public void setApeEstudiante(String ApeEstudiante) {
        this.ApeEstudiante = ApeEstudiante;
    }

    /**
     * @return the TipoDocu
     */
    public String getTipoDocu() {
        return TipoDocu;
    }

    /**
     * @param TipoDocu the TipoDocu to set
     */
    public void setTipoDocu(String TipoDocu) {
        this.TipoDocu = TipoDocu;
    }

    /**
     * @return the numeDocumento
     */
    public String getNumeDocumento() {
        return numeDocumento;
    }

    /**
     * @param numeDocumento the numeDocumento to set
     */
    public void setNumeDocumento(String numeDocumento) {
        this.numeDocumento = numeDocumento;
    }

    /**
     * @return the Edad
     */
    public String getEdad() {
        return Edad;
    }

    /**
     * @param Edad the Edad to set
     */
    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    /**
     * @return the Grado
     */
    public String getGrado() {
        return Grado;
    }

    /**
     * @param Grado the Grado to set
     */
    public void setGrado(String Grado) {
        this.Grado = Grado;
    }

    /**
     * @return the tipoBeneficio
     */
    public String getTipoBeneficio() {
        return tipoBeneficio;
    }

    /**
     * @param tipoBeneficio the tipoBeneficio to set
     */
    public void setTipoBeneficio(String tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }


    
    
}
