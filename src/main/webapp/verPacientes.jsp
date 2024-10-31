
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
    <h1 class="h3 mb-2 text-gray-800">Ver Pacientes</h1>
    <p class="mb-4">A continuación puede ver los datos de los Pacientes registrados</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Pacientes</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>dni</th>
                            <th>telefono</th>
                            <th>direccion</th>
                            <th>tipo de sangre</th>
                            <th>fecha nacimiento</th>
                            <th>tiene Obra Social</th>
                            <th style = "width: 210px">Acción</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>dni</th>
                            <th>telefono</th>
                            <th>direccion</th>
                            <th>tipo de sangre</th>
                            <th>fecha nacimiento</th>
                            <th>tiene Obra Social</th>
                            <th style = "width: 210px">Acción</th>
                        </tr>
                    </tfoot>
                    <% List<Paciente> pacientes = (List) request.getSession().getAttribute("pacientes"); %>
                    <tbody>
                        <% for (Paciente paci : pacientes) {%>
                        <tr>
                            <td><%= paci.getId_persona()%></td>
                            <td><%= paci.getNombre()%></td>
                            <td><%= paci.getApellido()%></td>
                            <td><%= paci.getDni()%></td>
                            <td><%= paci.getTelefono()%></td>
                            <td><%= paci.getDireccion()%></td>
                            <td><%= paci.getTipo_sangre()%></td>
                            <td><%=  DateUtils.formatearFechaPerso(paci.getFecha_nac())%></td>
                            <td>
                                <% if (paci.isTiene_OS()) { %>
                                Sí
                                <% } else { %>
                                No
                                <% }%>
                            </td>
                            <td style = "display: flex ; width: 210px">
                                <form action="SvEliminarPaciente" method="POST">
                                    <button type = "submit" class = "btn btn-primary btn-user btn-block" style = " background-color:red; margin-right:5px">
                                        <i class="fas fa-solid fa-trash"></i>
                                        eliminar</button> 
                                    <input name = "id" type= "hidden" value = "<%= paci.getId_persona() %>"/>
                                </form>
                                <form action="SvEditarPaciente" method="GET">
                                    <button type = "submit" class = "btn btn-primary btn-user btn-block" style = "margin-left:5px">
                                        <i class="fas fa-solid fa-pen"></i>
                                        editar</button> 
                                    <input name = "id" type= "hidden" value = "<%= paci.getId_persona() %>"/>
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