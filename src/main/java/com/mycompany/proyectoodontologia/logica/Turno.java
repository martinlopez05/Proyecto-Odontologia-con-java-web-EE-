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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */

@Entity
public class Turno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_turno;
    
    @Temporal(TemporalType.DATE)
    private Date fecha_turno;
    private String hora_turno; 
    private String afeccion;
    
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    
    @ManyToOne
    @JoinColumn(name = "id_odontologo")
    private Odontologo odonto;

    public Turno() {
    }

    public Turno(int id_turno, Date turno, String hora_turno, String afeccion) {
        this.id_turno = id_turno;
        this.fecha_turno = turno;
        this.hora_turno = hora_turno;
        this.afeccion = afeccion;
    }

    public int getId_turno() {
        return id_turno;
    }

    public Date getFecha_turno() {
        return fecha_turno;
    }

    public String getHora_turno() {
        return hora_turno;
    }

    public String getAfeccion() {
        return afeccion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Odontologo getOdonto() {
        return odonto;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public void setFecha_turno(Date fecha_turno) {
        this.fecha_turno = fecha_turno;
    }

    public void setHora_turno(String hora_turno) {
        this.hora_turno = hora_turno;
    }

    public void setAfeccion(String afeccion) {
        this.afeccion = afeccion;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setOdonto(Odontologo odonto) {
        this.odonto = odonto;
    }
    
    
    
    
}
