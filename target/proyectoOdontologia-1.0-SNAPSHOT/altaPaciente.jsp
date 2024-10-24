
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<h1>Alta Paciente</h1>

<br>
<form class="user" action="SvPaciente" method="POST">
    <div class="form-group col-sm-6 mb-3">
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="exampleFirstName"
                   name="nombrePaci" placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastName"
                   name="apellidoPaci" placeholder="Apellido">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleDNI"
                   name="dniPaci" placeholder="dni">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   name="telefonoPaci" id="exampleInputPassword" placeholder="Teléfono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   name="direccionPaci" id="exampleRepeatPassword" placeholder="Dirección">
        </div>
        <label>fecha de nacimiento</label><br>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user"
                   name="fechaNacPaci" id="exampleRepeatPassword" placeholder="Fecha de Nac.">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   id="exampleTipoSangre" name="tipoSangrePaci" placeholder="Tipo de Sangre">
        </div>

        <div class="form-group col-sm-6 mb-3">
            <label>¿Tiene obra social?</label><br>
            <div class="form-check form-check-inline">
                <input type="radio" id="obraSocialSi" name="obraSocialPaci" value="si" class="form-check-input">
                <label for="obraSocialSi" class="form-check-label">Sí</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="radio" id="obraSocialNo" name="obraSocialPaci" value="no" class="form-check-input">
                <label for="obraSocialNo" class="form-check-label">No</label>
            </div>
        </div>


        <br>
        <h4>Si el paciente es menor de edad, el adulto responsable deberá llenar el siguiente formulario</h4>
        <br>
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="exampleFirstNameRespon"
                   name="nombreRespon" placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastNameRespon"
                   name="apellidoRespon" placeholder="Apellido">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleDNIRespon"
                   name="dniRespon" placeholder="DNI">
        </div>

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   name="telefonoRespon" id="exampleInputPasswordRespon" placeholder="Teléfono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   name="direccionRespon" id="exampleRepeatPasswordRespon" placeholder="Dirección">
        </div>
        <label>fecha de nacimiento</label><br>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user"
                   name="fechaNacRespon" id="exampleRepeatPasswordRespon" placeholder="Fecha de Nac.">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   name="tipoRespon" id="exampleInputPasswordRespon" placeholder="tipo de responsable">
        </div>
    </div>
    <br>
    <button  class="btn btn-primary btn-user btn-block" type = "submit" >
        registrar paciente
    </button>

    <hr>

</form>
<%@include file="components/bodyfinal.jsp" %>