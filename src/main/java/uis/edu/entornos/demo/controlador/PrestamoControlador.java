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
import uis.edu.entornos.demo.modelo.Prestamo;
import uis.edu.entornos.demo.modelo.PrestamoLibroUsuarioRequest;
import uis.edu.entornos.demo.servicio.PrestamoServicio;

/**
 *
 * @author crist
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/prestamo")
public class PrestamoControlador {
    @Autowired
    PrestamoServicio prestamoServicio;
    
    @GetMapping("/lista")
    public List<Prestamo> ConsultarTodoPrestamo(){
        return (prestamoServicio.getPrestamos());
    }
    
    @GetMapping("/lista/{id}")
    public Prestamo BuscarPrestamoPorId(@PathVariable int id){
        return prestamoServicio.buscarPrestamo(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<Prestamo> agregarPrestamo(@RequestBody PrestamoLibroUsuarioRequest request){
        Prestamo prestamo = request.getPrestamo();
        int libro = request.getId_libro();
        int usuario = request.getId_usuario();
        
        Prestamo obj = prestamoServicio.nuevoPrestamo(prestamo,libro,usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping("/")
    public ResponseEntity<Prestamo> editarPrestamo(@RequestBody PrestamoLibroUsuarioRequest request){
        Prestamo prestamo = request.getPrestamo();
        int libro = request.getId_libro();
        int usuario = request.getId_usuario();
        Prestamo obj = prestamoServicio.buscarPrestamo(prestamo.getIdPrestamo());
        if ( obj != null ){
            obj.setUsuarioFK(prestamo.getUsuarioFK());
            obj.setLibroFK(prestamo.getLibroFK());
            obj.setFechaPrestamo(prestamo.getFechaPrestamo());
            obj.setFechaDevolucion(prestamo.getFechaDevolucion());
            prestamoServicio.editarPrestamo(obj,libro,usuario);
        }else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Prestamo> eliminarPrestamo (@PathVariable int id){
        Prestamo obj = prestamoServicio.buscarPrestamo(id);
        if (obj != null) {
            prestamoServicio.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(obj,HttpStatus.OK);
    }
}
