package com.example.laommedic.jpa.entities;

import com.example.laommedic.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-18T18:12:19")
@StaticMetamodel(Ocupacion.class)
public class Ocupacion_ { 

    public static volatile SingularAttribute<Ocupacion, String> nombreOcupacion;
    public static volatile SingularAttribute<Ocupacion, String> idOcupacion;
    public static volatile ListAttribute<Ocupacion, Usuario> usuarios;

}