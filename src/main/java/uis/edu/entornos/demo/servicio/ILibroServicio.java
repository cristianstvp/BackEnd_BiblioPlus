/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entornos.demo.servicio;

import java.util.List;
import uis.edu.entornos.demo.modelo.Libro;

/**
 *
 * @author crist
 */
public interface ILibroServicio {
    
    public List<Libro> getLibros();
    
    public Libro nuevoLibro(Libro libroDto, int id_autor);
    
    public Libro editarLibro(Libro libroDto, int id_autor);
    
    public Libro buscarLibro(int id);
    
    public void delete(int id);
}
