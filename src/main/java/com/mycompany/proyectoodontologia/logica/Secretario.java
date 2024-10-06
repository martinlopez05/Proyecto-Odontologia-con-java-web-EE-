/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoodontologia.logica;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Usuario
 */

@Entity
public class Secretario extends Persona{
    
    @OneToOne
    private Usuario usuario;
    private String sector;

    public Secretario(Usuario usuario, String sector, int id_persona, String dni, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id_persona, dni, apellido, telefono, direccion, fecha_nac);
        this.usuario = usuario;
        this.sector = sector;
    }

    

    public Secretario() {
    }

    

    public Usuario getUsuario() {
        return usuario;
    }

    public String getSector() {
        return sector;
    }

    

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
    
    
    
}
