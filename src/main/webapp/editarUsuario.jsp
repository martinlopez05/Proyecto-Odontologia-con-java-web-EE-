<%-- 
    Document   : editarUsuario
    Created on : 6 oct. 2024, 20:04:52
    Author     : Usuario
--%>

<%@page import="com.mycompany.proyectoodontologia.logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "components/header.jsp" %>
<%@include file = "components/bodyprimeraparte.jsp" %>
<h1>Editar Usuario</h1>
<p>Este es el apartado para la modificación de los datos del usuario</p>
<% Usuario usu = (Usuario) request.getSession().getAttribute("usuario"); %>
<form class="user" action = "SvEditarUsuario" method="POST">
    
    <div class="form-group col-sm-6 mb-3">
        
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="nombreUsuario" name="nombreUsuario"
                   value = "<%=usu.getNombreUsuario() %>" placeholder="nombre de usuario">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                value ="<%=usu.getContrasenia() %>"   placeholder="contraseña">
        </div>
        
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol" name="rol"
                value = "<%=usu.getRol()%> "   placeholder="rol">
        </div>
    
    </div>
    <button class="btn btn-primary btn-user btn-block" type = "submit">
        guardar cambios
    </button>
    <hr>

</form>
<%@include file = "components/bodyfinal.jsp" %>
