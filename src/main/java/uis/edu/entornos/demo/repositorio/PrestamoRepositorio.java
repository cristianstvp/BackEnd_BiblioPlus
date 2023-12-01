/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entornos.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entornos.demo.modelo.Prestamo;

/**
 *
 * @author crist
 */
public interface PrestamoRepositorio extends JpaRepository<Prestamo, Integer>{
    
}
