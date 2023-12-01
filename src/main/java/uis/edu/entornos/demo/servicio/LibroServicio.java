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
import uis.edu.entornos.demo.modelo.Autor;
import uis.edu.entornos.demo.modelo.Libro;
import uis.edu.entornos.demo.repositorio.AutorRepositorio;
import uis.edu.entornos.demo.repositorio.LibroRepositorio;

/**
 *
 * @author crist
 */
@Service
@Transactional
public class LibroServicio implements ILibroServicio{
    
    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Override
    public List<Libro> getLibros() {
        return libroRepositorio.findAll();
    }

    @Override
    public Libro nuevoLibro(Libro libroDto, int id_autor) {
        Optional<Autor> autorOptional = autorRepositorio.findById(id_autor);
        Libro libro = new Libro();
        Autor autor = autorOptional.get();
        
        libro.setTitulo(libroDto.getTitulo());
        libro.setAutorFK(autor);
        libro.setGenero(libroDto.getGenero());
        libro.setAnioPublicacion(libroDto.getAnioPublicacion());
        libro.setCantidadDisponible(libroDto.getCantidadDisponible());
        return libroRepositorio.save(libro);
    }
    
    @Override
    public Libro editarLibro(Libro libroDto, int id_autor) {
        Optional<Autor> autorOptional = autorRepositorio.findById(id_autor);
        Libro libro = new Libro();
        Autor autor = autorOptional.get();
        
        libro.setIdLibro(libroDto.getIdLibro());
        libro.setTitulo(libroDto.getTitulo());
        libro.setAutorFK(autor);
        libro.setGenero(libroDto.getGenero());
        libro.setAnioPublicacion(libroDto.getAnioPublicacion());
        libro.setCantidadDisponible(libroDto.getCantidadDisponible());
        return libroRepositorio.save(libro);
    }

    @Override
    public Libro buscarLibro(int id) {
        return libroRepositorio.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        libroRepositorio.deleteById(id);
    }
}
