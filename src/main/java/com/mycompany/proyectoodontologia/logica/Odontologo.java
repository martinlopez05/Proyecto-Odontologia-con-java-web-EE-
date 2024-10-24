/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoodontologia.logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Usuario
 */

@Entity
public class Odontologo extends Persona implements Serializable{
    
    private String especialidad;
    
    @OneToMany(mappedBy = "odonto")
    private List<Turno> turnos;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Horario horario;
    
    @OneToOne
    private Usuario usuario;

    public Odontologo(String especialidad, List<Turno> turnos, Horario horario, int id_persona, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id_persona, dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.especialidad = especialidad;
        this.turnos = turnos;
        this.horario = horario;
    }

   

    public Odontologo(String especialidad, List<Turno> turnos, Horario horario) {
        this.especialidad = especialidad;
        this.turnos = turnos;
        this.horario = horario;
    }

  
    

    public Odontologo() {
    }

    

    public String getEspecialidad() {
        return especialidad;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public Horario getHorario() {
        return horario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
    
}
