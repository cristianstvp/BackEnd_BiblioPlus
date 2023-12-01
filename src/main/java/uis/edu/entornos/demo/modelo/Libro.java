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
import jakarta.persistence.Table;

/**
 *
 * @author crist
 */
@Entity
@Table (name = Libro.TABLE_NAME)
public class Libro {
    
    public static final String TABLE_NAME = "libro";
    @Id // identifica llave primaria
    @GeneratedValue (strategy = GenerationType.IDENTITY) // identifica el autoincremento
    private int libroID;
    
    
    @Column(name = "titulo")
    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "autorFK")
    private Autor autorFK;
    
    @Column(name = "genero")
    private String genero;
    
    @Column(name = "anioPublicacion")
    private int anioPublicacion;
    
    @Column(name = "cantidadDisponible")
    private int cantidadDisponible;

    public Libro() {
    }

    public Libro(int idLibro, Autor autorFK, String Titulo, String genero, int anioPublicacion, int cantidadDisponible) {
        this.libroID = idLibro;
        this.autorFK = autorFK;
        this.titulo = Titulo;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getIdLibro() {
        return libroID;
    }

    public void setIdLibro(int idLibro) {
        this.libroID = idLibro;
    }

    public Autor getAutorFK() {
        return autorFK;
    }

    public void setAutorFK(Autor autorFK) {
        this.autorFK = autorFK;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String Titulo) {
        this.titulo = Titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}
