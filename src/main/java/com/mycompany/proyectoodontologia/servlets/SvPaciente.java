/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectoodontologia.servlets;

import com.mycompany.proyectoodontologia.logica.Controladora;
import com.mycompany.proyectoodontologia.logica.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DateUtils;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "SvPaciente", urlPatterns = {"/SvPaciente"})
public class SvPaciente extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Paciente> pacientes = control.traerPacientes();
        System.out.println("Pacientes obtenidos: " + pacientes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("pacientes", pacientes);
        response.sendRedirect("verPacientes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombrePaciente = request.getParameter("nombrePaci");
        String apellidoPaciente = request.getParameter("apellidoPaci");
        String telefonoPaciente = request.getParameter("telefonoPaci");
        String direccionPaciente = request.getParameter("direccionPaci");
        String tipoSangrePaciente = request.getParameter("tipoSangrePaci");
        String txtObrasocialPaciente = request.getParameter("obraSocialPaci");
        String dniPaciente = request.getParameter("dniPaci");
        boolean tieneOSpaciente = "si".equalsIgnoreCase(txtObrasocialPaciente);

        Date fechaNacimientoPaciente = DateUtils.parseFecha(request.getParameter("fechaNacPaci"));
        LocalDate fechaNacimientoLocal = new java.sql.Date(fechaNacimientoPaciente.getTime()).toLocalDate();
        Period edad = Period.between(fechaNacimientoLocal, LocalDate.now());

        String nombreResponsable = request.getParameter("nombreRespon");
        String apellidoResponsable = request.getParameter("apellidoRespon");
        String telefonoResponsable = request.getParameter("telefonoRespon");
        String direccionResponsable = request.getParameter("direccionRespon");
        String dniResponsable = request.getParameter("dniRespon");
        String tipoResponsable = request.getParameter("tipoRespon");
        Date fechaNacimientoResponsable = DateUtils.parseFecha(request.getParameter("fechaNacRespon"));

        boolean tieneResponsable = nombreResponsable != null && !nombreResponsable.isEmpty()
                && apellidoResponsable != null && !apellidoResponsable.isEmpty()
                && telefonoResponsable != null && !telefonoResponsable.isEmpty()
                && direccionResponsable != null && !direccionResponsable.isEmpty()
                && dniResponsable != null && !dniResponsable.isEmpty()
                && tipoResponsable != null && !tipoResponsable.isEmpty();

        if (tieneResponsable) {
            control.crearPaciente(nombrePaciente, apellidoPaciente, direccionPaciente, telefonoPaciente, fechaNacimientoPaciente, tipoSangrePaciente, tieneOSpaciente, dniPaciente,
                    nombreResponsable, apellidoResponsable, direccionResponsable, telefonoResponsable, dniResponsable, fechaNacimientoResponsable, tipoResponsable);
        } else {
            control.crearPaciente(nombrePaciente, apellidoPaciente, direccionPaciente, telefonoPaciente, fechaNacimientoPaciente, tipoSangrePaciente, tieneOSpaciente, dniPaciente);
        }
        
        response.sendRedirect("index.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
