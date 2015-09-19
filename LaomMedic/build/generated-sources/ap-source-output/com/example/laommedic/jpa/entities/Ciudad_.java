package com.example.laommedic.jpa.entities;

import com.example.laommedic.jpa.entities.Departamento;
import com.example.laommedic.jpa.entities.Sede;
import com.example.laommedic.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-18T18:12:20")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile ListAttribute<Ciudad, Sede> sedes;
    public static volatile SingularAttribute<Ciudad, Departamento> departamento;
    public static volatile ListAttribute<Ciudad, Usuario> usuarios;
    public static volatile SingularAttribute<Ciudad, String> nombre;
    public static volatile SingularAttribute<Ciudad, Integer> idCiudad;

}