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
import uis.edu.entornos.demo.modelo.Autor;
import uis.edu.entornos.demo.servicio.AutorServicio;
/**
 *
 * @author crist
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/autor")
public class AutorControlador {
    
    @Autowired
    private AutorServicio autorServicio;
    
    @GetMapping("/lista")
    public List<Autor> ConsultarTodoAutor(){
        return (autorServicio.getAutores());
    }
    
    @GetMapping("/lista/{id}")
    public Autor BuscarAutorPorId(@PathVariable int id){
        return autorServicio.buscarAutor(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<Autor> agregarAutor(@RequestBody Autor autor){
        Autor obj = autorServicio.nuevoAutor(autor);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
   
@PutMapping("/")
public ResponseEntity<Autor> editarAutor(@RequestBody Autor autor) {
    Autor obj = autorServicio.buscarAutor(autor.getIdAutor()); 
    if (obj != null) {
        obj.setNombre(autor.getNombre());
        obj.setNacionalidad(autor.getNacionalidad()); 
        obj.setFechaNacimiento(autor.getFechaNacimiento());
        autorServicio.nuevoAutor(obj);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Autor> eliminarAutor (@PathVariable int id){
        Autor obj = autorServicio.buscarAutor(id);
        if (obj != null) {
            autorServicio.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    // Ruta para la URL raíz "/"
    @GetMapping("/")
    public String paginaPrincipal() {
        return "¡Bienvenido a la página principal!";
    }
}
