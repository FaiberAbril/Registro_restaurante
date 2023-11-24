/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author CATA
 */
public class Registrar_Admin {
    
    private int IdUsuario;
    private String Nombres;
    private String Apellidos;
    private String TipoDocumento;
    private String NumDocumento;
    private String Cargo;
    private String Usuario;
    private String Pass;

    public Registrar_Admin() {
    }

    
    
    public Registrar_Admin(int IdUsuario, String Nombres, String Apellidos, String TipoDocumento, String NumDocumento, String Cargo, String Usuario, String Pass) {
        this.IdUsuario = IdUsuario;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.TipoDocumento = TipoDocumento;
        this.NumDocumento = NumDocumento;
        this.Cargo = Cargo;
        this.Usuario = Usuario;
        this.Pass = Pass;
    }

    /**
     * @return the IdUsuario
     */
    public int getIdUsuario() {
        return IdUsuario;
    }

    /**
     * @param IdUsuario the IdUsuario to set
     */
    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    /**
     * @return the Nombres
     */
    public String getNombres() {
        return Nombres;
    }

    /**
     * @param Nombres the Nombres to set
     */
    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    /**
     * @return the Apellidos
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    /**
     * @return the TipoDocumento
     */
    public String getTipoDocumento() {
        return TipoDocumento;
    }

    /**
     * @param TipoDocumento the TipoDocumento to set
     */
    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    /**
     * @return the NumDocumento
     */
    public String getNumDocumento() {
        return NumDocumento;
    }

    /**
     * @param NumDocumento the NumDocumento to set
     */
    public void setNumDocumento(String NumDocumento) {
        this.NumDocumento = NumDocumento;
    }

    /**
     * @return the Cargo
     */
    public String getCargo() {
        return Cargo;
    }

    /**
     * @param Cargo the Cargo to set
     */
    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Pass
     */
    public String getPass() {
        return Pass;
    }

    /**
     * @param Pass the Pass to set
     */
    public void setPass(String Pass) {
        this.Pass = Pass;
    }

      
    
}
