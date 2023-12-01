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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

/**
 *
 * @author crist
 */
@Entity
@Table (name = Prestamo.TABLE_NAME)
public class Prestamo {
    
    public static final String TABLE_NAME = "prestamo";
    @Id // identifica llave primaria
    @GeneratedValue (strategy = GenerationType.IDENTITY) // identifica el autoincremento
    private int prestamoID;
    
    
    // @ManyToOne hace referencia a la relacion muchos a uno que tiene usuario con tipoDocumento
    // @JoinColumn hace referencia a que es una llave foranea 
    @ManyToOne
    @JoinColumn(name = "usuarioFK")
    private Usuario usuarioFK;
    
    @ManyToOne
    @JoinColumn(name = "libroFK")
    private Libro libroFK;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaPrestamo")
    private Date fechaPrestamo;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaDevolucion")
    private Date fechaDevolucion;

    public Prestamo() {
    }

    public Prestamo(int idPrestamo, Usuario usuarioFK, Libro LibroFK, Date FechaPrestamo, Date FechaDevolucion) {
        this.prestamoID = idPrestamo;
        this.usuarioFK = usuarioFK;
        this.libroFK = LibroFK;
        this.fechaPrestamo = FechaPrestamo;
        this.fechaDevolucion = FechaDevolucion;
    }

    public int getIdPrestamo() {
        return prestamoID;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.prestamoID = idPrestamo;
    }

    public Usuario getUsuarioFK() {
        return usuarioFK;
    }

    public void setUsuarioFK(Usuario usuarioFK) {
        this.usuarioFK = usuarioFK;
    }

    public Libro getLibroFK() {
        return libroFK;
    }

    public void setLibroFK(Libro LibroFK) {
        this.libroFK = LibroFK;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date FechaPrestamo) {
        this.fechaPrestamo = FechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date FechaDevolucion) {
        this.fechaDevolucion = FechaDevolucion;
    }
}
