package com.example.laommedic.jpa.entities;

import com.example.laommedic.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-18T18:12:20")
@StaticMetamodel(TipoDocumento.class)
public class TipoDocumento_ { 

    public static volatile SingularAttribute<TipoDocumento, String> idTipoDocumento;
    public static volatile ListAttribute<TipoDocumento, Usuario> usuarios;
    public static volatile SingularAttribute<TipoDocumento, String> nombre;

}