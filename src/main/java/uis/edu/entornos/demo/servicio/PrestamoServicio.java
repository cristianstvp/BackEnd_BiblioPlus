/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.demo.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uis.edu.entornos.demo.modelo.Libro;
import uis.edu.entornos.demo.modelo.Prestamo;
import uis.edu.entornos.demo.modelo.Usuario;
import uis.edu.entornos.demo.repositorio.LibroRepositorio;
import uis.edu.entornos.demo.repositorio.PrestamoRepositorio;
import uis.edu.entornos.demo.repositorio.UsuarioRepositorio;

/**
 *
 * @author crist
 */
@Service
@Transactional
public class PrestamoServicio implements IPrestamoServicio{
    
    @Autowired
    PrestamoRepositorio prestamoRepositorio;

    @Autowired
    LibroRepositorio libroRepositorio;
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Override
    
    public List<Prestamo> getPrestamos() {
        return prestamoRepositorio.findAll();
    }

    @Override
    public Prestamo nuevoPrestamo(Prestamo prestamoDto,int id_libro, int id_usuario) {
        Optional<Libro> libroOptional = libroRepositorio.findById(id_libro);
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(id_usuario);
        Libro libro = libroOptional.get();
        Usuario usuario = usuarioOptional.get();
        Prestamo prestamo = new Prestamo();
        
        prestamo.setLibroFK(libro);
        prestamo.setUsuarioFK(usuario);
        prestamo.setFechaPrestamo(prestamoDto.getFechaPrestamo());
        prestamo.setFechaDevolucion(prestamoDto.getFechaDevolucion());
        return prestamoRepositorio.save(prestamo);
    }

    @Override
    public Prestamo editarPrestamo(Prestamo prestamoDto,int id_libro, int id_usuario) {
        Optional<Libro> libroOptional = libroRepositorio.findById(id_libro);
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(id_usuario);
        Libro libro = libroOptional.get();
        Usuario usuario = usuarioOptional.get();
        Prestamo prestamo = new Prestamo();
        
        prestamo.setIdPrestamo(prestamoDto.getIdPrestamo());
        prestamo.setLibroFK(libro);
        prestamo.setUsuarioFK(usuario);
        prestamo.setFechaPrestamo(prestamoDto.getFechaPrestamo());
        prestamo.setFechaDevolucion(prestamoDto.getFechaDevolucion());
        return prestamoRepositorio.save(prestamo);
    }
    @Override
    public Prestamo buscarPrestamo(int id) {
        return prestamoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        prestamoRepositorio.deleteById(id);
    }
}
