/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectoodontologia.servlets;

import com.mycompany.proyectoodontologia.logica.Controladora;
import static java.awt.SystemColor.control;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
    
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
        
        String nombreUsuario = request.getParameter("nomUsuario");
        String contrasenia = request.getParameter("contrasenia");
        
        boolean validacion = control.comprobarIngreso(nombreUsuario,contrasenia);
        
        if(validacion == true){
            HttpSession misesion = request.getSession(true);
            misesion.setAttribute("nombreUsuario", nombreUsuario);
            response.sendRedirect("index.jsp");
        }
        else{
            response.sendRedirect("loginError.jsp");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
