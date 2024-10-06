<%-- 
    Document   : altas
    Created on : 5 oct. 2024, 11:47:23
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<h1>Alta Odontólogo</h1>

<form class="user">
    <div class="form-group col-sm-6 mb-3">
        
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="exampleFirstName"
                   placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastName"
                   placeholder="Apellido">
        </div>
        
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastName"
                   placeholder="DNI">
        </div>
    
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   id="exampleInputPassword" placeholder="telefono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   id="exampleRepeatPassword" placeholder="dirección">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   id="exampleRepeatPassword" placeholder="fecha_nac">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   id="exampleRepeatPassword" placeholder="especialidad">
        </div>
    </div>
    <a href="login.html" class="btn btn-primary btn-user btn-block">
        Registrar Odontólogo
    </a>
    <hr>

</form>
<%@include file="components/bodyfinal.jsp" %>