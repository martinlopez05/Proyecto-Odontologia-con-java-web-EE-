/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectoodontologia.servlets;

import com.mycompany.proyectoodontologia.logica.Controladora;
import com.mycompany.proyectoodontologia.logica.Horario;
import com.mycompany.proyectoodontologia.logica.Odontologo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "SvEditarOdontologo", urlPatterns = {"/SvEditarOdontologo"})
public class SvEditarOdontologo extends HttpServlet {
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idBuscar = Integer.parseInt(request.getParameter("id"));
        Odontologo odontoEditar = control.buscarOdontologo(idBuscar);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("odontoEditar", odontoEditar);
        
        response.sendRedirect("editarOdontologo.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String hora_inicio = request.getParameter("horainicio");
        String hora_fin = request.getParameter("horafin");

        
        String fechaNacStr = request.getParameter("fecha_nac");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        Date fecha_nac = null;
        
        try {
            fecha_nac = formato.parse(fechaNacStr); 
        }  
        catch (java.text.ParseException ex) {
            Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Odontologo odontoEditar = (Odontologo) request.getSession().getAttribute("odontoEditar");
        odontoEditar.setNombre(nombre);
        odontoEditar.setApellido(apellido);
        odontoEditar.setDireccion(direccion);
        odontoEditar.setDni(dni);
        odontoEditar.setFecha_nac(fecha_nac);
        odontoEditar.setTelefono(telefono);
        
        Horario horarioEditar = odontoEditar.getHorario();
        horarioEditar.setHorario_inicio(hora_inicio);
        horarioEditar.setHorario_fin(hora_fin);
        
        try {
            control.editarHorario(horarioEditar);
            control.editarOdontologo(odontoEditar);
            
        } catch (Exception ex) {
            Logger.getLogger(SvEditarOdontologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("SvOdontologo");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
