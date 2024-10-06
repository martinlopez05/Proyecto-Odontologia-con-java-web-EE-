/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoodontologia.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Usuario
 */

@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    
    private String nombreUsuario;
    private String contrasenia;
    private String rol;

    

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombreUsuario, String contraseña, String rol) {
        this.id_usuario = id_usuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contraseña;
        this.rol = rol;
    }

    public Usuario(String nombreUsuario, String contraseña, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contraseña;
        this.rol = rol;
    }
    
    

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getRol() {
        return rol;
    }

    

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contrasenia = contraseña;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
}
