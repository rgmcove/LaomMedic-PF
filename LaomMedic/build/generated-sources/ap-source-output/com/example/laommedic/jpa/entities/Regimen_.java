package com.example.laommedic.jpa.entities;

import com.example.laommedic.jpa.entities.Clinica;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-18T18:12:19")
@StaticMetamodel(Regimen.class)
public class Regimen_ { 

    public static volatile SingularAttribute<Regimen, String> idRegimen;
    public static volatile ListAttribute<Regimen, Clinica> clinicas;
    public static volatile SingularAttribute<Regimen, String> nombreRegimen;

}