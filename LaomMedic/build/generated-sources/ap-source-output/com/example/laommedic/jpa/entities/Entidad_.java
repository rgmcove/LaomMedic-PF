package com.example.laommedic.jpa.entities;

import com.example.laommedic.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-18T18:12:19")
@StaticMetamodel(Entidad.class)
public class Entidad_ { 

    public static volatile SingularAttribute<Entidad, String> idEntidad;
    public static volatile SingularAttribute<Entidad, String> nombreEntidad;
    public static volatile ListAttribute<Entidad, Usuario> usuarios;

}