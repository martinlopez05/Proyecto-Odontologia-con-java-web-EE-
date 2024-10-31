
<%@page import="utils.DateUtils"%>
<%@page import="com.mycompany.proyectoodontologia.logica.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<h1>Editar Paciente</h1>
<%Paciente paciEditar = (Paciente) request.getSession().getAttribute("pacienteEditar");%>
<br>
<form class="user" action="SvEditarPaciente" method="POST">

    <div class="form-group col-sm-6 mb-3">
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="exampleFirstName"
                   name="nombrePaci" placeholder="Nombre" value= "<%=paciEditar.getNombre()%>" >
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastName"
                   name="apellidoPaci" placeholder="Apellido" value="<%=paciEditar.getApellido()%>">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleDNI"
                   name="dniPaci" placeholder="dni" value="<%=paciEditar.getDni()%>">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   name="telefonoPaci" id="exampleInputPassword" placeholder="Teléfono" value="<%=paciEditar.getTelefono()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   name="direccionPaci" id="exampleRepeatPassword" placeholder="Dirección" value="<%=paciEditar.getDireccion()%>">
        </div>
        <label>fecha de nacimiento</label><br>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user"
                   name="fechaNacPaci" id="exampleRepeatPassword" placeholder="Fecha de Nac." value="<%=DateUtils.formatearFecha(paciEditar.getFecha_nac())%>">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   id="exampleTipoSangre" name="tipoSangrePaci" placeholder="Tipo de Sangre" value="<%=paciEditar.getTipo_sangre()%>">
        </div>

        <div class="form-group col-sm-6 mb-3">
            <label>¿Tiene obra social?</label><br>
            <div class="form-check form-check-inline">
                <input type="radio" id="obraSocialSi" name="obraSocialPaci" value="si" class="form-check-input"
                       <%= paciEditar.isTiene_OS() ? "checked" : ""%>>
                <label for="obraSocialSi" class="form-check-label">Sí</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="radio" id="obraSocialNo" name="obraSocialPaci" value="no" class="form-check-input"
                       <%= !paciEditar.isTiene_OS() ? "checked" : ""%>>
                <label for="obraSocialNo" class="form-check-label">No</label>
            </div>
        </div>



        <br>
        <h4>Si el paciente es menor de edad, el adulto responsable deberá llenar el siguiente formulario</h4>
        <br>

        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="exampleFirstNameRespon"
                   name="nombreRespon" placeholder="Nombre" 
                   value="<%= (paciEditar.getResponsable() != null) ? paciEditar.getResponsable().getNombre() : ""%>">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastNameRespon"
                   name="apellidoRespon" placeholder="Apellido" 
                   value="<%= (paciEditar.getResponsable() != null) ? paciEditar.getResponsable().getApellido() : ""%>">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleDNIRespon"
                   name="dniRespon" placeholder="DNI" 
                   value="<%= (paciEditar.getResponsable() != null) ? paciEditar.getResponsable().getDni() : ""%>">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleInputPasswordRespon"
                   name="telefonoRespon" placeholder="Teléfono" 
                   value="<%= (paciEditar.getResponsable() != null) ? paciEditar.getResponsable().getTelefono() : ""%>">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleRepeatPasswordRespon"
                   name="direccionRespon" placeholder="Dirección" 
                   value="<%= (paciEditar.getResponsable() != null) ? paciEditar.getResponsable().getDireccion() : ""%>">
        </div>

        <label>Fecha de nacimiento</label><br>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" id="exampleRepeatPasswordRespon"
                   name="fechaNacRespon" placeholder="Fecha de Nac." 
                   value="<%= (paciEditar.getResponsable() != null) ? DateUtils.formatearFecha(paciEditar.getResponsable().getFecha_nac()) : ""%>">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleInputPasswordRespon"
                   name="tipoRespon" placeholder="Tipo de responsable" 
                   value="<%= (paciEditar.getResponsable() != null) ? paciEditar.getResponsable().getTipo_responsable() : ""%>">
        </div>

    </div>
    <br>
    <button  class="btn btn-primary btn-user btn-block" type = "submit" >
        editar paciente
    </button>

    <hr>

</form>
<%@include file="components/bodyfinal.jsp" %>