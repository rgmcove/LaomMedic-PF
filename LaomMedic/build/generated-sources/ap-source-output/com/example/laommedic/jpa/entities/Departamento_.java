package com.example.laommedic.jpa.entities;

import com.example.laommedic.jpa.entities.Ciudad;
import com.example.laommedic.jpa.entities.Pais;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-18T18:12:19")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, Integer> idDepartamento;
    public static volatile SingularAttribute<Departamento, String> nombre;
    public static volatile ListAttribute<Departamento, Ciudad> ciudades;
    public static volatile SingularAttribute<Departamento, Pais> pais;

}