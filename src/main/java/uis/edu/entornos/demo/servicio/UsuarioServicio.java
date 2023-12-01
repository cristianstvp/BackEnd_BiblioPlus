/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.demo.servicio;

import jakarta.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uis.edu.entornos.demo.modelo.LoginDto;
import uis.edu.entornos.demo.modelo.UsuarioDto;
import uis.edu.entornos.demo.modelo.Usuario;
import uis.edu.entornos.demo.repositorio.UsuarioRepositorio;

/**
 *
 * @author crist
 */
@Service
@Transactional
public class UsuarioServicio implements IUsuarioServicio{
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario nuevoUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario buscarUsuario(int id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        usuarioRepositorio.deleteById(id);
    }
    
    @Override
    public int login(LoginDto usuarioDto) {
        int u = usuarioRepositorio.findByNombreUsuarioAndPassword(usuarioDto.getNombre_usuario(), usuarioDto.getContrasena());
        return u;
    }

    @Override
    public ResponseEntity<?> ingresar(LoginDto usuarioDto) {
        Map<String, Object> response = new HashMap<>();
        Usuario usuario = null;
        try {
            usuario = usuarioRepositorio.findByNameAndPassword(usuarioDto.getNombre_usuario(), usuarioDto.getContrasena());
            if (usuario == null) {
                response.put("Usuario", null);
                response.put("Mensaje", "Alerta:Usuario o Password incorrectos");
                response.put("statusCode", HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                response.put("Usuario", usuario);
                response.put("Mensaje", "Datos correctos");
                response.put("statusCode", HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            response.put("Usuario", null);
            response.put("Mensaje", "Ha ocurrido un error");
            response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
