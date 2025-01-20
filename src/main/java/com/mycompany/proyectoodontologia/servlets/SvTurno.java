/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectoodontologia.servlets;

import com.mycompany.proyectoodontologia.logica.Controladora;
import com.mycompany.proyectoodontologia.logica.Odontologo;
import com.mycompany.proyectoodontologia.logica.Paciente;
import com.mycompany.proyectoodontologia.logica.Turno;
import static com.mycompany.proyectoodontologia.logica.Turno_.paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "SvTurno", urlPatterns = {"/SvTurno"})
public class SvTurno extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("altaTurno".equals(action)) {
            List<Odontologo> odontologos = control.traerOdontologos();
            HttpSession session = request.getSession();
            session.setAttribute("odontologos", odontologos);

            List<Paciente> pacientes = control.traerPacientes();
            session.setAttribute("pacientes", pacientes);

            request.getRequestDispatcher("altaTurno.jsp").forward(request, response);

        } else if ("verTurnos".equals(action)) {
            List<Turno> turnos = control.traerTurnos();
            HttpSession session = request.getSession();
            session.setAttribute("turnos", turnos);
            request.getRequestDispatcher("verTurnos.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int odontologoId = Integer.parseInt(request.getParameter("odontologoId"));
        int pacienteId = Integer.parseInt(request.getParameter("pacienteId"));
        String afeccion = request.getParameter("afeccion");
        String horarioTurno = request.getParameter("horaTurno");
        String fechaTurnoStr = request.getParameter("fechaTurno");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaTurno = null;

        try {
            fechaTurno = formato.parse(fechaTurnoStr);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
        }

        control.crearTurno(odontologoId, pacienteId, afeccion, fechaTurno, horarioTurno);
        response.sendRedirect("index.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
