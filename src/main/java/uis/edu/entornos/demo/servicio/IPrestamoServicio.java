/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entornos.demo.servicio;

import java.util.List;
import uis.edu.entornos.demo.modelo.Prestamo;

/**
 *
 * @author crist
 */
public interface IPrestamoServicio {
    
    public List<Prestamo> getPrestamos();
    
    public Prestamo nuevoPrestamo(Prestamo prestamoDto, int id_libro ,int id_usuario);
   
    public Prestamo editarPrestamo(Prestamo prestamoDto, int id_libro ,int id_usuario);

    public Prestamo buscarPrestamo(int id);
    
    public void delete(int id);
}
