<%-- 
    Document   : verUsuarios
    Created on : 6 oct. 2024, 17:25:49
    Author     : Usuario
--%>

<%@page import="com.mycompany.proyectoodontologia.logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "components/header.jsp" %>
<%@include file = "components/bodyprimeraparte.jsp" %>
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver usuarios</h1>
    <p class="mb-4">A continuación puede ver los datos de los usuarios registrados</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre de Usuario</th>
                            <th>Rol</th>
                            <th style = "width: 210px">Acción</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Nombre de Usuario</th>
                            <th>Rol</th>
                            <th style = "width: 210px">Acción</th>
                            
                        </tr>
                    </tfoot>
                    <% List<Usuario> usuarios = (List) request.getSession().getAttribute("usuarios"); %>
                    <tbody>
                        <% for (Usuario usu : usuarios) {%>
                        <tr>
                            <td><%= usu.getId_usuario() %></td>
                            <td><%= usu.getNombreUsuario() %></td>
                            <td><%= usu.getRol() %></td>
                            <td style = "display: flex ; width: 210px">
                                <form action="SvEliminarUsuario" method="POST">
                                    <button type = "submit" class = "btn btn-primary btn-user btn-block" style = " background-color:red; margin-right:5px">
                                        <i class="fas fa-solid fa-trash"></i>
                                        eliminar</button> 
                                    <input name = "id" type= "hidden" value = "<%= usu.getId_usuario() %>"/>
                                </form>
                                <form action="SvEditarUsuario" method="GET">
                                    <button type = "submit" class = "btn btn-primary btn-user btn-block" style = "margin-left:5px">
                                        <i class="fas fa-solid fa-pen"></i>
                                        editar</button> 
                                    <input name = "id" type= "hidden" value = "<%= usu.getId_usuario() %>"/>
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
