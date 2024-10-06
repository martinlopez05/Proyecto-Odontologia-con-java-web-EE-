<%-- 
    Document   : altas
    Created on : 5 oct. 2024, 11:47:23
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<h1>Alta Usuario</h1>

<form class="user" action = "SvUsuario" method="POST">
    <div class="form-group col-sm-6 mb-3">
        
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="nombreUsuario" name="nombreUsuario"
                   placeholder="Nombre de usuario">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="contraseña">
        </div>
        
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol" name="rol"
                   placeholder="rol">
        </div>
    
    </div>
    <button class="btn btn-primary btn-user btn-block" type = "submit">
        Registrar usuario
    </button>
    <hr>

</form>
<%@include file="components/bodyfinal.jsp" %>
