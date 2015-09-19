package com.example.laommedic.jpa.entities;

import com.example.laommedic.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-18T18:12:20")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> nombreRol;
    public static volatile SingularAttribute<Rol, String> idRoles;
    public static volatile ListAttribute<Rol, Usuario> usuarios;

}