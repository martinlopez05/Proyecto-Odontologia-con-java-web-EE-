/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoodontologia.logica.persistencia;

import com.mycompany.proyectoodontologia.logica.Horario;
import com.mycompany.proyectoodontologia.logica.Odontologo;
import com.mycompany.proyectoodontologia.logica.Paciente;
import com.mycompany.proyectoodontologia.logica.Responsable;
import com.mycompany.proyectoodontologia.logica.Usuario;
import com.mycompany.proyectoodontologia.logica.persistencia.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ControladoraPersistencia {
    
    HorarioJpaController horarioJpa = new HorarioJpaController();
    OdontologoJpaController odontologoJpa = new OdontologoJpaController();
    PacienteJpaController pacienteJpa = new PacienteJpaController();
    ResponsableJpaController responsableJpa = new ResponsableJpaController();
    SecretarioJpaController secretarioJpa = new SecretarioJpaController();
    TurnoJpaController turnoJpa = new TurnoJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();

    public void crearUsuario(Usuario usuario) {
        usuarioJpa.create(usuario);
    }

    public List<Usuario> traerUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }

    public void eliminarUsuario(int id) throws NonexistentEntityException {
        usuarioJpa.destroy(id);
    }

    public Usuario buscarUsuario(int id) {
        return usuarioJpa.findUsuario(id);
    }

    public void editarUsuario(Usuario usuario) throws Exception {
        usuarioJpa.edit(usuario);
    }

    public void crearHorario(Horario horario) {
        horarioJpa.create(horario);
    }

    public void crearOdontologo(Odontologo odontologo) {
        odontologoJpa.create(odontologo);
    }

    public List<Odontologo> traerOdontologos() {
        return odontologoJpa.findOdontologoEntities();
    }

    public Odontologo buscarOdontologo(int id) {
        return odontologoJpa.findOdontologo(id);
    }

    public void editarOdontologo(Odontologo odonto) throws Exception {
        odontologoJpa.edit(odonto);
    }

    public void editarHorario(Horario horario) throws Exception {
        horarioJpa.edit(horario);
    }

    public void eliminarOdontologo(int id) throws NonexistentEntityException {
        odontologoJpa.destroy(id);
    }

    public void crearResponsable(Responsable responsable) {
        responsableJpa.create(responsable);
    }

    public void crearPaciente(Paciente paciente) {
        pacienteJpa.create(paciente);
    }

    public List<Paciente> traerPacientes() {
        return pacienteJpa.findPacienteEntities();
    }

    public void eliminarPaciente(int id) throws NonexistentEntityException {
        pacienteJpa.destroy(id);
    }

    public Paciente buscarPaciente(int id) {
        return pacienteJpa.findPaciente(id);
    }

    public void editarPaciente(Paciente paciente) throws Exception {
        pacienteJpa.edit(paciente);
    }

    public void editarResponsable(Responsable responsable) throws Exception {
        responsableJpa.edit(responsable);
    }

    
    
}
