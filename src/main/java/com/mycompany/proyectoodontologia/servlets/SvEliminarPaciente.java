/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectoodontologia.servlets;

import com.mycompany.proyectoodontologia.logica.Controladora;
import com.mycompany.proyectoodontologia.logica.persistencia.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "SvEliminarPaciente", urlPatterns = {"/SvEliminarPaciente"})
public class SvEliminarPaciente extends HttpServlet {
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEliminarPaciente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEliminarPaciente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idEliminar = Integer.parseInt(request.getParameter("id"));
        try {
            control.eliminarPaciente(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(SvEliminarPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("SvPaciente");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
