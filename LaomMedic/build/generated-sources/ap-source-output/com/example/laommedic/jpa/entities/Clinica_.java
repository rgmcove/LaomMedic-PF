package com.example.laommedic.jpa.entities;

import com.example.laommedic.jpa.entities.Regimen;
import com.example.laommedic.jpa.entities.Sede;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-18T18:12:20")
@StaticMetamodel(Clinica.class)
public class Clinica_ { 

    public static volatile SingularAttribute<Clinica, Long> nitClinica;
    public static volatile ListAttribute<Clinica, Sede> sedes;
    public static volatile SingularAttribute<Clinica, String> direccion;
    public static volatile SingularAttribute<Clinica, String> nombreClinica;
    public static volatile SingularAttribute<Clinica, String> telefono;
    public static volatile SingularAttribute<Clinica, Regimen> regimen;
    public static volatile SingularAttribute<Clinica, String> email;

}