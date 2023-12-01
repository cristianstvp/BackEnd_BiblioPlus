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
import uis.edu.entornos.demo.modelo.LoginDto;
import uis.edu.entornos.demo.modelo.Usuario;
import uis.edu.entornos.demo.servicio.UsuarioServicio;

/**
 *
 * @author crist
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuario")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @GetMapping("/lista")
    public List<Usuario> ConsultarTodoUsuario(){
        return (usuarioServicio.getUsuarios());
    }
    
    @GetMapping("/lista/{id}")
    public Usuario BuscarUsuarioPorId(@PathVariable int id){
        return usuarioServicio.buscarUsuario(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario){
        Usuario obj = usuarioServicio.nuevoUsuario(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
 
    @PutMapping("/")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) {
        Usuario obj = usuarioServicio.buscarUsuario(usuario.getUsuarioID()); // Cambiar a getUsuarioID
        if (obj != null) {
            obj.setNombreUsuario(usuario.getNombreUsuario());
            obj.setPrimerNombre(usuario.getPrimerNombre()); // Cambiar a primerNombre
            obj.setApellido(usuario.getApellido());
            obj.setContrasena(usuario.getContrasena());
            usuarioServicio.nuevoUsuario(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminarUsuario (@PathVariable int id){
        Usuario obj = usuarioServicio.buscarUsuario(id);
        if (obj != null) {
            usuarioServicio.delete(id);
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
    
    /*
     * @CrossOrigin indica desde que sitios se van a realizar peticiones
     */
    //@CrossOrigin(origins = { "http://localhost:8010" })
    @PostMapping("/loginclient") // ruta del servicio desde el front deben direccionar a esta ruta
    public int login(@RequestBody LoginDto usuario) {
            int responseLogin = usuarioServicio.login(usuario);
            return responseLogin;
    }

    @PostMapping("/login") // ruta del servicio desde el front deben direccionar a esta ruta
    public ResponseEntity<?> loginCliente(@RequestBody LoginDto usuario) {
            return usuarioServicio.ingresar(usuario);
    }
    
}
