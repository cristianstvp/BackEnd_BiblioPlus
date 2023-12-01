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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

/**
 *
 * @author crist
 */
@Entity
@Table (name = Autor.TABLE_NAME)
public class Autor {
    public static final String TABLE_NAME = "autor";
    @Id // identifica llave primaria
    @GeneratedValue (strategy = GenerationType.IDENTITY) // identifica el autoincremento
    private int autorID;
    
    // @Column referencia en nombre de la columna en la BD con el nombre aqui en java. Si es el mismo, no es necesario esta accion
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "nacionalidad")
    private String nacionalidad;
    
    // Agrega esta anotación para la columna de tipo DATE
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimiento")
    private Date FechaNacimiento;
    
    public Autor() {
    }

    public Autor(int idAutor, Date FechaNacimiento, String Nombre, String nacionalidad) {
        this.autorID = idAutor;
        this.FechaNacimiento = FechaNacimiento;
        this.nombre = Nombre;
        this.nacionalidad = nacionalidad;
    }

    public int getIdAutor() {
        return autorID;
    }

    public void setIdAutor(int idAutor) {
        this.autorID = idAutor;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
}
