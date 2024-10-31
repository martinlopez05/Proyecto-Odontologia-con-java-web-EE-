/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectoodontologia.servlets;

import com.mycompany.proyectoodontologia.logica.Controladora;
import com.mycompany.proyectoodontologia.logica.Paciente;
import com.mycompany.proyectoodontologia.logica.Responsable;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
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
@WebServlet(name = "SvEditarPaciente", urlPatterns = {"/SvEditarPaciente"})
public class SvEditarPaciente extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idBuscar = Integer.parseInt(request.getParameter("id"));
        Paciente pacienteEditar = control.buscarPaciente(idBuscar);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("pacienteEditar", pacienteEditar);

        response.sendRedirect("editarPaciente.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Paciente paciEditar = (Paciente) request.getSession().getAttribute("pacienteEditar");

        String nombrePaciente = request.getParameter("nombrePaci");
        String apellidoPaciente = request.getParameter("apellidoPaci");
        String telefonoPaciente = request.getParameter("telefonoPaci");
        String direccionPaciente = request.getParameter("direccionPaci");
        String tipoSangrePaciente = request.getParameter("tipoSangrePaci");
        String txtObrasocialPaciente = request.getParameter("obraSocialPaci");
        String dniPaciente = request.getParameter("dniPaci");
        boolean tieneOSpaciente = "si".equalsIgnoreCase(txtObrasocialPaciente);

        Date fechaNacimientoPaciente = DateUtils.parseFecha(request.getParameter("fechaNacPaci"));

        paciEditar.setApellido(apellidoPaciente);
        paciEditar.setDireccion(direccionPaciente);
        paciEditar.setDni(dniPaciente);
        paciEditar.setFecha_nac(fechaNacimientoPaciente);
        paciEditar.setNombre(nombrePaciente);
        paciEditar.setTelefono(telefonoPaciente);
        paciEditar.setTipo_sangre(dniPaciente);
        paciEditar.setTiene_OS(tieneOSpaciente);

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
            Responsable respon;
            
            if (paciEditar.getResponsable() != null) {
                
                respon = paciEditar.getResponsable();
            } else {
                
                respon = new Responsable();
            }

            
            respon.setApellido(apellidoResponsable);
            respon.setDireccion(direccionResponsable);
            respon.setFecha_nac(fechaNacimientoResponsable);
            respon.setNombre(nombreResponsable);
            respon.setTelefono(telefonoResponsable);
            respon.setDni(dniResponsable);
            respon.setTipo_responsable(tipoResponsable);

            
            paciEditar.setResponsable(respon);

            try {
                control.editarPaciente(paciEditar);
            } catch (Exception ex) {
                Logger.getLogger(SvEditarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
            try {
                control.editarPaciente(paciEditar);
            } catch (Exception ex) {
                Logger.getLogger(SvEditarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        response.sendRedirect("SvPaciente");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
