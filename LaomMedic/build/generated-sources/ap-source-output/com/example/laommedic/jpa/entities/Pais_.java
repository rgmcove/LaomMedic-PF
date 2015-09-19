package com.example.laommedic.jpa.entities;

import com.example.laommedic.jpa.entities.Departamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-18T18:12:19")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, String> idPais;
    public static volatile ListAttribute<Pais, Departamento> departamentos;
    public static volatile SingularAttribute<Pais, String> nombre;

}