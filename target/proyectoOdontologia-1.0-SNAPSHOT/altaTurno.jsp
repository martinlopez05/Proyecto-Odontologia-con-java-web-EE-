<%@page import="com.mycompany.proyectoodontologia.logica.Paciente"%>
<%@page import="com.mycompany.proyectoodontologia.logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Alta Turnos</h1>
<% List<Odontologo> odontologos = (List) request.getSession().getAttribute("odontologos");%>
<% List<Paciente> pacientes = (List) request.getSession().getAttribute("pacientes");%>

<form class="user" action="SvTurno" method="POST">
    <div class="form-group col-sm-6 mb-3">
        <label for="odontologo" style="margin-right: 10px;">Seleccione un Odontólogo:</label>
        <select name="odontologoId" id="odontologo">
            <%
                for (Odontologo odontologo : odontologos) {
            %>
            <option class="btn-user btn-block" value="<%= odontologo.getId_persona()%>">
            <%= odontologo.getNombre()%> <%= odontologo.getApellido()%> <p>-</p> <%= odontologo.getDni() %> 
            </option>
            <%
                }
            %>
        </select>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastName"
                   style="margin-top:20px ; margin-bottom:50px"   name="afeccion" placeholder="Afección">
        </div>  

        <div style="display: flex; align-items: center;">  
            <label for="paciente" style="margin-right: 10px;">Seleccione Paciente:</label>  
            <select name="pacienteId" id="paciente" style="margin-right: 10px;">  
                <%
                    for (Paciente paciente : pacientes) {
                %>  
                <option class="btn-user btn-block" value="<%= paciente.getId_persona()%>">  
                    <%= paciente.getNombre()%> <%= paciente.getApellido()%> - <%= paciente.getDni()%>  
                </option>  
                <%
                    }
                %>  
            </select>  
            <p style="margin: 0;">o</p>  
            <button type="button" class="btn btn-primary btn-user" onclick="location.href = 'altaPaciente.jsp'" style="margin-left: 10px;">  
                Registrar Paciente  
            </button>  
        </div>

        <div class="col-sm-6 mb-3" style="margin-top:20px">
            <input type="text" class="form-control form-control-user"
                   id="exampleRepeatPassword" name="horaTurno" placeholder="Horario del turno">
        </div>
        <div class="col-sm-6 mb-3" style="margin-top:20px">
            <input type="date" class="form-control form-control-user"
                   id="exampleRepeatPassword" name="fechaTurno" placeholder="Fecha del turno">
        </div>
            
    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Registrar Turno
    </button>
    <hr>
</form>
<%@include file="components/bodyfinal.jsp" %>
