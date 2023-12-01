/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uis.edu.entornos.demo.modelo.Libro;
import uis.edu.entornos.demo.modelo.LibroAutorRequest;
import uis.edu.entornos.demo.servicio.LibroServicio;

/**
 *
 * @author crist
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/libro")
public class LibroControlador {
    
    @Autowired
    LibroServicio libroServicio;
    
    @GetMapping("/lista")
    public List<Libro> ConsultarTodoLibro(){
        return (libroServicio.getLibros());
    }
    
    @GetMapping("/lista/{id}")
    public Libro BuscarLibroPorId(@PathVariable int id){
        return libroServicio.buscarLibro(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<Libro> agregarLibro(@RequestBody LibroAutorRequest request){
        int autor = request.getId_autor();
        Libro libro = request.getLibro();
        
        Libro obj = libroServicio.nuevoLibro(libro, autor);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
   
    
    @PutMapping("/")
    public ResponseEntity<Libro> editarLibro(@RequestBody LibroAutorRequest request){
        int autor = request.getId_autor();
        Libro libro = request.getLibro();
        Libro obj = libroServicio.buscarLibro(libro.getIdLibro());
        
        if ( obj != null ){
            obj.setTitulo(libro.getTitulo());
            obj.setAutorFK(libro.getAutorFK());            
            obj.setGenero(libro.getGenero());
            obj.setAnioPublicacion(libro.getAnioPublicacion());
            obj.setCantidadDisponible(libro.getCantidadDisponible());
            libroServicio.editarLibro(obj,autor);
        }else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Libro> eliminarLibro (@PathVariable int id){
        Libro obj = libroServicio.buscarLibro(id);
        if (obj != null) {
            libroServicio.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(obj,HttpStatus.OK);
    }
}
