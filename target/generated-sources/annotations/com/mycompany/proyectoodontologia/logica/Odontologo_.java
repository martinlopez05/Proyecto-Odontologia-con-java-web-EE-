package com.mycompany.proyectoodontologia.logica;

import com.mycompany.proyectoodontologia.logica.Horario;
import com.mycompany.proyectoodontologia.logica.Turno;
import com.mycompany.proyectoodontologia.logica.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-01-20T19:29:59")
@StaticMetamodel(Odontologo.class)
public class Odontologo_ extends Persona_ {

    public static volatile SingularAttribute<Odontologo, Horario> horario;
    public static volatile ListAttribute<Odontologo, Turno> turnos;
    public static volatile SingularAttribute<Odontologo, Usuario> usuario;

}