<%-- 
    Document   : verUsuarios
    Created on : 6 oct. 2024, 17:25:49
    Author     : Usuario
--%>

<%@page import="com.mycompany.proyectoodontologia.logica.Odontologo"%>
<%@page import="com.mycompany.proyectoodontologia.logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "components/header.jsp" %>
<%@include file = "components/bodyprimeraparte.jsp" %>
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Odontologos</h1>
    <p class="mb-4">A continuación puede ver los datos de los odontólogos registrados</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Odontólogos</h6>
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
                            <th>especialidad</th>
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
                            <th>especialidad</th>
                            <th style = "width: 210px">Acción</th>

                        </tr>
                    </tfoot>
                    <% List<Odontologo> odontologos = (List) request.getSession().getAttribute("odontologos"); %>
                    <tbody>
                        <% for (Odontologo odon : odontologos) {%>
                        <tr>
                            <td><%= odon.getId_persona()%></td>
                            <td><%= odon.getNombre()%></td>
                            <td><%= odon.getApellido()%></td>
                            <td><%= odon.getDni()%></td>
                            <td><%= odon.getTelefono()%></td>
                            <td><%= odon.getDireccion()%></td>
                            <td><%= odon.getEspecialidad()%></td>
                            <td style = "display: flex ; width: 210px">
                                <form action="SvEliminarOdontologo" method="POST">
                                    <button type = "submit" class = "btn btn-primary btn-user btn-block" style = " background-color:red; margin-right:5px">
                                        <i class="fas fa-solid fa-trash"></i>
                                        eliminar</button> 
                                    <input name = "id" type= "hidden" value = "<%= odon.getId_persona()%>"/>
                                </form>
                                <form action="SvEditarOdontologo" method="GET">
                                    <button type = "submit" class = "btn btn-primary btn-user btn-block" style = "margin-left:5px">
                                        <i class="fas fa-solid fa-pen"></i>
                                        editar</button> 
                                    <input name = "id" type= "hidden" value = "<%= odon.getId_persona()%>"/>
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
