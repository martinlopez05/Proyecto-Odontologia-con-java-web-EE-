<%-- 
    Document   : altas
    Created on : 5 oct. 2024, 11:47:23
    Author     : Usuario
--%>

<%@page import="utils.DateUtils"%>
<%@page import="com.mycompany.proyectoodontologia.logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<h1>Editar Odontólogo</h1>
<% Odontologo odontoEditar = (Odontologo) request.getSession().getAttribute("odontoEditar");%>
<form class="user" action="SvEditarOdontologo" method="POST">
    <div class="form-group col-sm-6 mb-3">

        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="exampleFirstName"
                   name="nombre"  value=<%= odontoEditar.getNombre()%> placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastName"
                   name="apellido"   value=<%= odontoEditar.getApellido()%> placeholder="Apellido">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastName"
                   name="dni" value=<%= odontoEditar.getDni()%>  placeholder="dni">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   name="telefono"  value=<%= odontoEditar.getTelefono()%>  id="exampleInputPassword" placeholder="telefono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   name="direccion" value=<%= odontoEditar.getDireccion()%>   id="exampleRepeatPassword" placeholder="dirección">
        </div>
        
        <label>fecha de nacimiento</label><br>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user"
                   name="fecha_nac" value="<%= DateUtils.formatearFecha(odontoEditar.getFecha_nac()) %>" id="exampleRepeatPassword" placeholder="fecha_nac">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   id="exampleRepeatPassword" name="horainicio" value=<%= odontoEditar.getHorario().getHorario_inicio()%>   placeholder="horario inicio">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   id="exampleRepeatPassword" name="horafin"  value=<%= odontoEditar.getHorario().getHorario_fin()%> placeholder="horario fin">
        </div>
    </div>
    <button  class="btn btn-primary btn-user btn-block" type = "submit" >
        editar odontólogo
    </button>

    <hr>

</form>
<%@include file = "components/bodyfinal.jsp" %>
