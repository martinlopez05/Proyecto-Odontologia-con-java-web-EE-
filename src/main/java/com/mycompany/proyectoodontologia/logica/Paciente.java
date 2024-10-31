/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoodontologia.logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Usuario
 */

@Entity
public class Paciente extends Persona implements Serializable {
    
    
    private boolean tiene_OS;
    private String tipo_sangre;
    
    @OneToMany(mappedBy = "paciente")
    private List<Turno> turnos;
    
    @OneToOne
    private Responsable responsable;

    
    
    public Paciente() {
    }

    public Paciente(boolean tiene_OS, String tipo_sangre,String nombre, List<Turno> turnos, Responsable responsable, int id_persona, String dni, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id_persona, dni,nombre, apellido, telefono, direccion, fecha_nac);
        this.tiene_OS = tiene_OS;
        this.tipo_sangre = tipo_sangre;
        this.turnos = turnos;
        this.responsable = responsable;
    }
    
    

    

    public boolean isTiene_OS() {
        return tiene_OS;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public Responsable getResponsable() {
        return responsable;
    }
    
    

    public void setTiene_OS(boolean tiene_OS) {
        this.tiene_OS = tiene_OS;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
    
    
    
    
    
}
