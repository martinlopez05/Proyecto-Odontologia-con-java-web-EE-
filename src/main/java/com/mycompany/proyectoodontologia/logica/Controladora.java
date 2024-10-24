/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoodontologia.logica;

import com.mycompany.proyectoodontologia.logica.persistencia.ControladoraPersistencia;
import com.mycompany.proyectoodontologia.logica.persistencia.exceptions.NonexistentEntityException;
import java.util.Date;
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
        usuario.setContrasenia(contraseña);
        usuario.setRol(rol);
        controlpersis.crearUsuario(usuario);
    }
    
    public List<Usuario> traerUsuarios(){
        return controlpersis.traerUsuarios();
    }
    
    public void eliminarUsuario(int id) throws NonexistentEntityException{
        controlpersis.eliminarUsuario(id);
        
    }
    
    public Usuario buscarUsuario(int id){
        return controlpersis.buscarUsuario(id);
    }
    
    public void editarUsuario(Usuario usuario) throws Exception{
        controlpersis.editarUsuario(usuario);
    }
    
    public boolean comprobarIngreso(String nombreUsuario,String contrasenia){
        List<Usuario> usuarios = controlpersis.traerUsuarios();
        
        boolean validar = false;
        
        for(Usuario usu : usuarios){
            if(usu.getNombreUsuario().equals(nombreUsuario)){
                if(usu.getContrasenia().equals(contrasenia)){
                   validar =  true;
                }
            }
            else{
                validar = false;
            }
        }
        
        return validar;
    }
    
    
    public void crearOdontologo(String especialidad,String hora_inicio,String hora_fin,String dni,String nombre, String apellido, String telefono, String direccion, Date fecha_nac){
        Horario horario = new Horario();
        horario.setHorario_inicio(hora_inicio);
        horario.setHorario_fin(hora_fin);
        this.crearHorario(hora_inicio, hora_fin);
        
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre(nombre);
        odontologo.setApellido(apellido);
        odontologo.setTelefono(telefono);
        odontologo.setDireccion(direccion);
        odontologo.setEspecialidad(especialidad);
        odontologo.setHorario(horario);
        odontologo.setDni(dni);
        odontologo.setFecha_nac(fecha_nac);
        
        controlpersis.crearOdontologo(odontologo);
    }
    
    
    public List<Odontologo> traerOdontologos(){
        return controlpersis.traerOdontologos();
    }
    
    
    public Odontologo buscarOdontologo(int id){
        return controlpersis.buscarOdontologo(id);
    }
    
    
    public void editarOdontologo(Odontologo odonto) throws Exception{
        controlpersis.editarOdontologo(odonto);
    }
    
    
    public void editarHorario(Horario horario) throws Exception{
        controlpersis.editarHorario(horario);
    }
    
    public void crearHorario(String hora_inicio,String hora_fin){
        Horario horario = new Horario();
        horario.setHorario_inicio(hora_inicio);
        horario.setHorario_fin(hora_fin);
        controlpersis.crearHorario(horario);
    }
    
    
    
    
}
