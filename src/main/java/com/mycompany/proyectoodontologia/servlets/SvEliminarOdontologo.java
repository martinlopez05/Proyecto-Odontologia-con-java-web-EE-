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
@WebServlet(name = "SvEliminarOdontologo", urlPatterns = {"/SvEliminarOdontologo"})
public class SvEliminarOdontologo extends HttpServlet {
    
    Controladora control = new Controladora();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idBuscar = Integer.parseInt(request.getParameter("id"));
        try {
            control.eliminarOdontologo(idBuscar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(SvEliminarOdontologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("SvOdontologo");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
