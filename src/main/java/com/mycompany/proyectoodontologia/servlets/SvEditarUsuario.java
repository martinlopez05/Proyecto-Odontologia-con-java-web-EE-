/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectoodontologia.servlets;

import com.mycompany.proyectoodontologia.logica.Controladora;
import com.mycompany.proyectoodontologia.logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SvEditarUsuario", urlPatterns = {"/SvEditarUsuario"})
public class SvEditarUsuario extends HttpServlet {
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_usuario = Integer.parseInt(request.getParameter("id"));
        Usuario usuarioEditar = control.buscarUsuario(id_usuario);
        HttpSession misesion = request.getSession();
        misesion.setAttribute("usuario", usuarioEditar);
        response.sendRedirect("editarUsuario.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreUsuario = request.getParameter("nombreUsuario");
        String contrasenia = request.getParameter("contrasenia");
        String rol = request.getParameter("rol");
        Usuario usuarioEditar = (Usuario) request.getSession().getAttribute("usuario");
        
        usuarioEditar.setNombreUsuario(nombreUsuario);
        usuarioEditar.setContrasenia(contrasenia);
        usuarioEditar.setRol(rol);
        try {
            control.editarUsuario(usuarioEditar);
        } catch (Exception ex) {
            Logger.getLogger(SvEditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("SvUsuario");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
