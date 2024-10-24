/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoodontologia.logica;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Usuario
 */

@Entity
public class Responsable extends Persona {
    
    
    private String tipo_responsable;

    public Responsable(String tipo_responsable, int id_persona,String nombre, String dni, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id_persona, dni,nombre, apellido, telefono, direccion, fecha_nac);
        this.tipo_responsable = tipo_responsable;
    }
    
    
   
    public Responsable() {
    }

    

    public String getTipo_responsable() {
        return tipo_responsable;
    }

    

    public void setTipo_responsable(String tipo_responsable) {
        this.tipo_responsable = tipo_responsable;
    }
    
    
    
    
}
