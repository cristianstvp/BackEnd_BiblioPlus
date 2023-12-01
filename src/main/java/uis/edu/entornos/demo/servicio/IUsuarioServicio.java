/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.demo.servicio;

import java.util.List;
import org.springframework.http.ResponseEntity;
import uis.edu.entornos.demo.modelo.LoginDto;
import uis.edu.entornos.demo.modelo.Usuario;

/**
 *
 * @author crist
 */
public interface IUsuarioServicio {
        
    public List<Usuario> getUsuarios();
    
    public Usuario nuevoUsuario(Usuario usuario);
    
    public Usuario buscarUsuario(int id);
    
    public void delete(int id);
    
    int login(LoginDto usuarioDto);

    ResponseEntity<?> ingresar(LoginDto usuarioDto);
}
