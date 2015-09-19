package com.example.laommedic.jpa.entities;

import com.example.laommedic.jpa.entities.Ciudad;
import com.example.laommedic.jpa.entities.Entidad;
import com.example.laommedic.jpa.entities.Ocupacion;
import com.example.laommedic.jpa.entities.Rol;
import com.example.laommedic.jpa.entities.TipoDocumento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-18T18:12:19")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> segundoNombre;
    public static volatile SingularAttribute<Usuario, String> primerNombre;
    public static volatile SingularAttribute<Usuario, String> primerApellido;
    public static volatile SingularAttribute<Usuario, Date> fechaNacimiento;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, String> segundoApellido;
    public static volatile ListAttribute<Usuario, Ocupacion> ocupacion;
    public static volatile ListAttribute<Usuario, Rol> rol;
    public static volatile SingularAttribute<Usuario, Date> fechaIngreso;
    public static volatile SingularAttribute<Usuario, TipoDocumento> tipoDocumento;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, Character> grupoSanguineo;
    public static volatile SingularAttribute<Usuario, String> rh;
    public static volatile SingularAttribute<Usuario, Ciudad> ciudad;
    public static volatile SingularAttribute<Usuario, Entidad> entidad;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile SingularAttribute<Usuario, String> sexo;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile SingularAttribute<Usuario, Long> idIdentificacion;

}