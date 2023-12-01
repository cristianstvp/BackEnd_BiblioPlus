    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author crist
 */
@Entity
@Table (name = Usuario.TABLE_NAME)
public class Usuario {
    
    public static final String TABLE_NAME = "usuario";
    @Id // identifica llave primaria
    @GeneratedValue (strategy = GenerationType.IDENTITY) // identifica el autoincremento
    private int usuarioID;
    
    @Column(name = "nombre_usuario")
    private String nombre_usuario;

    @Column(name = "primer_nombre")
    private String primer_nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "contrasena")
    private String contrasena;
    
    public Usuario(){
    }

    public Usuario(int usuarioID, String nombreUsuario, String primerNombre, String apellido, String contrasena) {
        this.usuarioID = usuarioID;
        this.nombre_usuario = nombreUsuario;
        this.primer_nombre = primerNombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
    }
    
    // Getter y Setter

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getNombreUsuario() {
        return nombre_usuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombre_usuario = nombreUsuario;
    }

    public String getPrimerNombre() {
        return primer_nombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primer_nombre = primerNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
