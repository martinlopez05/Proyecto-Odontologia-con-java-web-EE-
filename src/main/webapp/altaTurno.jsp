<%@page import="com.mycompany.proyectoodontologia.logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Alta Turnos</h1>
<% List<Odontologo> odontologos = (List) request.getSession().getAttribute("odontologos");%>
<form class="user" action="SvTurno" method="POST">
    <div class="form-group col-sm-6 mb-3">
        <label for="odontologo">Seleccione un Odontólogo:</label>
        <select name="odontologoId" id="odontologo">
            <%
                for (Odontologo odontologo : odontologos) {
            %>
            <option value="<%= odontologo.getId_persona()%>">
                <%= odontologo.getNombre()%> <%= odontologo.getApellido()%>
            </option>
            <%
                }
            %>
        </select>


        <!-- Otros campos del formulario de turno -->

        <button type="submit">Guardar Turno</button>



        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="exampleFirstName"
                   name="odontologo"   placeholder="odontologo asignado">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastName"
                   name="afeccion"   placeholder="Afeccion">
        </div>  
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   name="telefono"   id="exampleInputPassword" placeholder="telefono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   name="direccion"   id="exampleRepeatPassword" placeholder="dirección">
        </div>

        <label>fecha de nacimiento</label><br>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user"
                   name="fecha_nac"   id="exampleRepeatPassword" placeholder="fecha_nac">
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