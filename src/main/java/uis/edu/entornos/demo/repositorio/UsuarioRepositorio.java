/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uis.edu.entornos.demo.modelo.Usuario;

/**
 *
 * @author crist
 */
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    // JPQL: Se hace la consulta sobre la clase 
    @Query("select count(*) from Usuario as p where p.nombre_usuario= :nombre_usuario and p.contrasena=:contrasena")
    Integer findByNombreUsuarioAndPassword(@Param("nombre_usuario") String nombre_usuario,
                    @Param("contrasena") String contrasena);


    @Query("select p from Usuario as p where p.nombre_usuario= :nombre_usuario and p.contrasena=:contrasena")
    Usuario findByNameAndPassword(@Param("nombre_usuario") String nombre_usuario,
                    @Param("contrasena") String contrasena);
}
