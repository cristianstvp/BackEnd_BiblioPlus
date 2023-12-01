/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entornos.demo.servicio;

import java.util.List;
import uis.edu.entornos.demo.modelo.Autor;

/**
 *
 * @author crist
 */
public interface IAutorServicio {
    
    public List<Autor> getAutores();
    
    public Autor nuevoAutor(Autor autor);
    
    public Autor buscarAutor(int id);
    
    public void delete(int id);
}
