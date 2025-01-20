<%@page import="com.mycompany.proyectoodontologia.logica.Turno"%>
<%@page import="utils.DateUtils"%>
<%@page import="com.mycompany.proyectoodontologia.logica.Paciente"%>
<%@page import="com.mycompany.proyectoodontologia.logica.Odontologo"%>
<%@page import="com.mycompany.proyectoodontologia.logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "components/header.jsp" %>
<%@include file = "components/bodyprimeraparte.jsp" %>
<div class="container-fluid">
   
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Turnos</h1>
    <p class="mb-4">A continuación puede ver los datos de los Turnos registrados</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Turnos</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Paciente</th>
                            <th>Odontologo</th>
                            <th>afeccion</th>
                            <th>fecha del turno</th>
                            <th>horario</th>
                            <th style = "width: 210px">Acción</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Paciente</th>
                            <th>Odontologo</th>
                            <th>afeccion</th>
                            <th>fecha del turno</th>
                            <th>horario</th>
                            <th style = "width: 210px">Acción</th>
                        </tr>
                    </tfoot>
                    <% List<Turno> turnos = (List) request.getSession().getAttribute("turnos"); %>
                    <tbody>
                        <% for (Turno turno : turnos) {%>
                        <tr>
                            <td><%= turno.getId_turno()%></td>
                            <td><%= turno.getPaciente().getNombre()%> <%= turno.getPaciente().getApellido()%> - <%= turno.getPaciente().getDni()%> </td>
                            <td><%= turno.getOdonto().getNombre() %> <%= turno.getOdonto().getApellido()%> - <%= turno.getOdonto().getDni()%> </td>
                            <td><%= turno.getAfeccion() %></td>
                            <td><%=  DateUtils.formatearFechaPerso(turno.getFecha_turno())%></td>
                            <td><%= turno.getHora_turno() %></td>
                            <td style = "display: flex ; width: 210px">
                                <form action="SvEliminarTurno" method="POST">
                                    <button type = "submit" class = "btn btn-primary btn-user btn-block" style = " background-color:red; margin-right:5px">
                                        <i class="fas fa-solid fa-trash"></i>
                                        eliminar</button> 
                                    <input name = "id" type= "hidden" value = "<%= turno.getId_turno()%>"/>
                                </form>
                               
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>

<%@include file = "components/bodyfinal.jsp" %>
