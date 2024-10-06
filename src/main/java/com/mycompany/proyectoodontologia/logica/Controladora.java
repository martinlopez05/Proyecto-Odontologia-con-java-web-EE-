/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoodontologia.logica;

import com.mycompany.proyectoodontologia.logica.persistencia.ControladoraPersistencia;
import com.mycompany.proyectoodontologia.logica.persistencia.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Controladora {
    
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    
    public void crearUsuario(String nombre,String contraseña, String rol){
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombre);
        usuario.setContraseña(contraseña);
        usuario.setRol(rol);
        controlpersis.crearUsuario(usuario);
    }
    
    public List<Usuario> traerUsuarios(){
        return controlpersis.traerUsuarios();
    }
    
    public void eliminarUsuario(int id) throws NonexistentEntityException{
        controlpersis.eliminarUsuario(id);
        
    }
    
}
