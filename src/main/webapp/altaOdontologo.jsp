<%-- 
    Document   : altas
    Created on : 5 oct. 2024, 11:47:23
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<h1>Alta Odontólogo</h1>

<form class="user" action="SvOdontologo" method="POST">
    <div class="form-group col-sm-6 mb-3">
        
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="exampleFirstName"
                name="nombre"   placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastName"
                name="apellido"   placeholder="Apellido">
        </div>
        
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastName"
                name="dni"   placeholder="dni">
        </div>
    
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                name="telefono"   id="exampleInputPassword" placeholder="telefono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                name="direccion"   id="exampleRepeatPassword" placeholder="dirección">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user"
                name="fecha_nac"   id="exampleRepeatPassword" placeholder="fecha_nac">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                name="especialidad"   id="exampleRepeatPassword" placeholder="especialidad">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                id="exampleRepeatPassword" name="horainicio"placeholder="horario inicio">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   id="exampleRepeatPassword" name="horafin" placeholder="horario fin">
        </div>
    </div>
    <button  class="btn btn-primary btn-user btn-block" type = "submit" >
        registrar odontólogo
    </button>
   
    <hr>

</form>
<%@include file="components/bodyfinal.jsp" %>