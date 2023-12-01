/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.demo.servicio;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entornos.demo.modelo.Autor;
import uis.edu.entornos.demo.repositorio.AutorRepositorio;

/**
 *
 * @author crist
 */
@Service
@Transactional
public class AutorServicio implements IAutorServicio{
    
    @Autowired
    private AutorRepositorio autorRepositorio;

    @Override
    public List<Autor> getAutores() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor nuevoAutor(Autor autor) {
        return autorRepositorio.save(autor);
    }

    @Override
    public Autor buscarAutor(int id) {
        return autorRepositorio.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        autorRepositorio.deleteById(id);
    }
}
