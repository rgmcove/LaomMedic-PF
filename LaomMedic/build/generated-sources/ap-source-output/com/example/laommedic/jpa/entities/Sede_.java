package com.example.laommedic.jpa.entities;

import com.example.laommedic.jpa.entities.Ciudad;
import com.example.laommedic.jpa.entities.Clinica;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-18T18:12:20")
@StaticMetamodel(Sede.class)
public class Sede_ { 

    public static volatile SingularAttribute<Sede, String> nombreSede;
    public static volatile SingularAttribute<Sede, Integer> idSedes;
    public static volatile SingularAttribute<Sede, Ciudad> ciudad;
    public static volatile SingularAttribute<Sede, Clinica> clinica;
    public static volatile SingularAttribute<Sede, String> sedePpal;
    public static volatile SingularAttribute<Sede, String> direccion;
    public static volatile SingularAttribute<Sede, String> telefono;

}